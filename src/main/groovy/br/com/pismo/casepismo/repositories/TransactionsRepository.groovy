package br.com.pismo.casepismo.repositories

import br.com.pismo.casepismo.models.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionsRepository extends JpaRepository<Transaction, Long>{

}
