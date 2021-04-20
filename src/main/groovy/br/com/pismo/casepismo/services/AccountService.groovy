package br.com.pismo.casepismo.services

import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.repositories.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.persistence.EntityExistsException
import javax.persistence.EntityNotFoundException

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository


    Account create(Account account) throws EntityExistsException{
        def find = accountRepository.findByDocumentNumber(account.documentNumber)

        if(find){
            throw new EntityExistsException("Account already exist")
        }
        accountRepository.save(account)
    }

    Account findById(long id){
        accountRepository.findById(id).orElseThrow({
            throw new EntityNotFoundException("Account not exist")
        })
    }
}
