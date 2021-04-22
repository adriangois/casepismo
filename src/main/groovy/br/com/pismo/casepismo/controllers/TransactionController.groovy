package br.com.pismo.casepismo.controllers

import br.com.pismo.casepismo.exceptions.AccountExceptions
import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.models.OperationsType
import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.requesters.TransactionRequest
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
import java.text.SimpleDateFormat

@RestController
@RequestMapping('transactions')
class TransactionController {

    @Autowired
    TransactionsService transactionService


    @PostMapping('')
    def create(@RequestBody TransactionRequest transactionRequest){
        transactionService.create(mapperTransaction(transactionRequest))
    }


    @GetMapping('')
    def findAll(){
        def listOut = new ArrayList()
        //Output map
        transactionService.findAll().each {
            def map = [:]
            map.put "account_id", it.account.accountId
            map.put "operation_type_id", it.operationsType.operationsTypeId
            map.put "ammount" , it.ammount
            map.put "event_date" , it.eventDate
            listOut.add(map)
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
    private mapperTransaction(TransactionRequest transactionRequest){
        new Transaction(ammount: transactionRequest.ammount
                , account: new Account(accountId:  transactionRequest.account_id),
                operationsType: new OperationsType(operationsTypeId: transactionRequest.operations_type_id))
    }

}
