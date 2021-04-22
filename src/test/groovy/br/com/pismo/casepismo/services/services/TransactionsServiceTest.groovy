package br.com.pismo.casepismo.services.services

import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.models.OperationsType
import br.com.pismo.casepismo.models.Transaction
import br.com.pismo.casepismo.repositories.TransactionsRepository
import br.com.pismo.casepismo.services.TransactionsService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class TransactionsServiceTest {

    @Mock
    TransactionsRepository transactionsRepository

    @InjectMocks
    TransactionsService transactionsService

    @Autowired
    TransactionsService transactionsServiceReal


    @Test
    void createTransactionTest(){
        Mockito.when(transactionsRepository.save(Mockito.any(Transaction.class)))
                .thenReturn(new Transaction(account:  new Account(accountId: 1)))

        def transaction = new Transaction(account:   new Account(accountId: 1), operationsType: new OperationsType(operationsTypeId: 1), ammount: 123)
        Transaction tReturned = transactionsService.create(transaction)

        assertThat(tReturned.account.accountId).is(1)

    }

    @Test
    void findAllTransactions(){
        def lista = transactionsServiceReal.findAll()
        assertThat(lista.size()).isGreaterThan(1)
    }


    @Test
    void operationTypeTest(){
        assertThat(transactionsService.operationType(1)).is(-1)
        assertThat(transactionsService.operationType(2)).is(-1)
        assertThat(transactionsService.operationType(3)).is(-1)
        assertThat(transactionsService.operationType(4)).is(1)
    }


    @Test
    void findByDateTest(){
        def tran =  transactionsService.findByDate(new Date())

    }


}
