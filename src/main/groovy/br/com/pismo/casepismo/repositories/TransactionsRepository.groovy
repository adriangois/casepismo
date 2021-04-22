package br.com.pismo.casepismo.repositories

import br.com.pismo.casepismo.models.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TransactionsRepository extends JpaRepository<Transaction, Long>{


}


