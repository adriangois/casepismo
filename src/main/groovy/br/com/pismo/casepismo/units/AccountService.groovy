package br.com.pismo.casepismo.units

import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.repositories.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository


    Account create(Account account){
        accountRepository.save(account)
    }

    Account findById(long id){
        accountRepository.findById(id).orElse(null)
    }
}
