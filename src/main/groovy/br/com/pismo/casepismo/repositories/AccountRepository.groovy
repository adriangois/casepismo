package br.com.pismo.casepismo.repositories

import br.com.pismo.casepismo.models.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByDocumentNumber(String document)
}
