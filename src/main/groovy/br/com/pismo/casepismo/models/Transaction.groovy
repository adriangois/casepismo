package br.com.pismo.casepismo.models

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity
class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id

    @Column(nullable = false)
    Double ammount

    @Column(nullable = false)
    @JsonIgnore
    Date eventDate = Date.newInstance()

    @ManyToOne(optional = false)
    @JsonIgnore
    OperationsType operationsType

    @ManyToOne(optional = false)
    @JsonIgnore
    Account account

}
