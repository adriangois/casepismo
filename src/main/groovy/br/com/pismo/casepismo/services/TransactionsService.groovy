package br.com.pismo.casepismo.services

import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.repositories.TransactionsRepository
import br.com.pismo.casepismo.util.OperationsTypeEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionsService {


    @Autowired
    TransactionsRepository transactionsRepository

    def create(Transaction transaction) {
        transaction?.ammount = transaction?.ammount * this.operationType(transaction?.operationsType?.id)
        transactionsRepository.save(transaction)
    }

    int operationType(long operationTypeId){
        if(OperationsTypeEnum.PAGAMENTO.getValue() == operationTypeId){
            1
        }else{
            -1
        }
    }

    def findAll() {
        transactionsRepository.findAll()
    }


}
