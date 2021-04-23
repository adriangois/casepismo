package br.com.pismo.casepismo.controllers

import br.com.pismo.casepismo.exceptions.AccountExceptions
import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.models.OperationsType
import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.requesters.TransactionPojo
import br.com.pismo.casepismo.services.TransactionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.persistence.EntityExistsException
import javax.persistence.PersistenceException

@RestController
@RequestMapping('transactions')
class TransactionController {

    @Autowired
    TransactionsService transactionService


    @PostMapping('')
    def create(@RequestBody TransactionPojo transactionRequest) {
        def out = transactionService.create(mapper(transactionRequest))
        mapperReturnCreate(out)
    }


    @GetMapping('')
    def findAll() {
        def listOut = new ArrayList()
        transactionService.findAll().each {
            listOut.add(mapperReturnToList(it))
        }
        listOut
    }


    @ExceptionHandler([PersistenceException.class])
    def handleException(Exception ex) {
        if (ex instanceof EntityExistsException)
            new ResponseEntity<Object>(new AccountExceptions(ex.message, HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT)
        else {
            new ResponseEntity<Object>(new AccountExceptions(ex.message, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    /**
     * Method for map trasaction request to entity
     * @param transactionRequest
     * @return Transaction entity
     */
    private mapper(TransactionPojo transactionRequest) {
        new Transaction(ammount: transactionRequest.ammount
                , account: new Account(id: transactionRequest.account_id),
                operationsType: new OperationsType(id: transactionRequest.operations_type_id))
    }

    /**
     * Mothod for map transaction returned in create accord the documentation
     * @param out
     * @return
     */
    private Map mapperReturnCreate(Transaction out) {
        def map = [:]
        map.put("ammount", out.ammount)
        map.put("operations_type_id", out.operationsType?.id)
        map.put("account_id", out.account?.id)
        map
    }

    /**
     * Private Method for map the return to list transactions
     * @param out
     * @return
     */
    private TransactionPojo mapperReturnToList(Transaction out) {
        new TransactionPojo(event_date: out?.eventDate, account_id: out.account?.id, ammount: out?.ammount, operations_type_id: out?.operationsType?.id)
    }

}
