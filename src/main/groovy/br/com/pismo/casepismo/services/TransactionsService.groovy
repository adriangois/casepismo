package br.com.pismo.casepismo.services

import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.repositories.TransactionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionsService {


    @Autowired
    TransactionsRepository transactionsRepository

    def create(Transaction transaction) {
        transaction?.ammount = transaction?.ammount * operationType(transaction?.operationsType?.operationsTypeId)
        transactionsRepository.save(transaction)
    }

    def operationType(long operationTypeId){
        if(operationTypeId == 4){
            1
        }else{
            -1
        }
    }

    def findAll() {
        transactionsRepository.findAll()
    }


    def findByDate(Date date) {
            transactionsRepository.findByDate(date)
    }
}
