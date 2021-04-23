package br.com.pismo.casepismo.services.services

import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.repositories.AccountRepository
import br.com.pismo.casepismo.services.AccountService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class AccountServiceTest {


    @Mock
    AccountRepository accountRepository

    @InjectMocks
    AccountService accountService


    @Test
    void shouldGetAccountById() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(id: 1, documentNumber: '3')))
        Account returnedAccount = accountService.findById(1)
        assertThat(returnedAccount.id).is(1)
    }


    @Test
    void shouldCreateAccount() {
        Account newAccount = new Account(id: 2, documentNumber: '34')
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(newAccount)
        Account returned = accountService.create(newAccount)
        assertThat(returned.id).is(2)
    }


}
