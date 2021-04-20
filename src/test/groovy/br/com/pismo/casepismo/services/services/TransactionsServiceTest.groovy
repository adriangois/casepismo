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
import org.springframework.boot.test.context.SpringBootTest
import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class TransactionsServiceTest {

    @Mock
    TransactionsRepository transactionsRepository

    @InjectMocks
    TransactionsService transactionsService


    @Test
    void createTransactionTest(){
        Mockito.when(transactionsRepository.save(Mockito.any(Transaction.class)))
                .thenReturn(new Transaction(account:  new Account(accountId: 1)))

        def transaction = new Transaction(account:   new Account(accountId: 1), operationsType: new OperationsType(operationsTypeId: 1), ammount: 123)
        Transaction tReturned = transactionsService.create(transaction)

        assertThat(tReturned.account.accountId).is(1)

    }

}
