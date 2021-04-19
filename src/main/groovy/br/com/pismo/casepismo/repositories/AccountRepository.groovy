package br.com.pismo.casepismo.repositories

import br.com.pismo.casepismo.models.Account
import org.springframework.data.repository.PagingAndSortingRepository

interface AccountRepository extends PagingAndSortingRepository<Account, Long>{
}
