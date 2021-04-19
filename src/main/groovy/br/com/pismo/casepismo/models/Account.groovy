package br.com.pismo.casepismo.models

import org.springframework.lang.NonNull

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountId

    @Column(nullable = false)
    String documentNumber

}
