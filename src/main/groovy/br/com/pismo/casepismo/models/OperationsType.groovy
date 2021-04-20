package br.com.pismo.casepismo.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GeneratorType

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class OperationsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long operationsTypeId

    @Column(nullable = false)
    String description

    @OneToMany(fetch = FetchType.LAZY, mappedBy = 'operationsType')
    List<Transaction> transactions



}
