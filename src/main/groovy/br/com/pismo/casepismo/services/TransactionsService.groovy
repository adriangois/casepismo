package br.com.pismo.casepismo.services

import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.repositories.TransactionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionsService {


    @Autowired
    TransactionsRepository transactionsRepository

    def create(Transaction transaction){
        transactionsRepository.save(transaction)
    }


    def findAll(){
        transactionsRepository.findAll()
    }


}
