package br.com.pismo.casepismo.requesters

import com.fasterxml.jackson.annotation.JsonFormat

class TransactionPojo {

    Long account_id
    Long operations_type_id
    Double ammount
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "br")
    Date event_date

}
