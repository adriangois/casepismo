package br.com.pismo.casepismo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.lang.NonNull

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("account_id")
    Long id

    @Column(nullable = false)
    @JsonProperty("document_number")
    String documentNumber

    @OneToMany(fetch = FetchType.LAZY, mappedBy = 'account')
    @JsonIgnore
    List<Transaction> transactions



}
