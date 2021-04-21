package br.com.pismo.casepismo.models

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.util.JSONWrappedObject

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long transactionId

    @Column(nullable = false)
    Double ammount
    @Column(nullable = false)
    Date eventDate = new Date()



    @ManyToOne( optional = false)
    @JsonIgnore
    OperationsType operationsType

    @ManyToOne(optional = false)
    @JsonIgnore
    Account account

}
