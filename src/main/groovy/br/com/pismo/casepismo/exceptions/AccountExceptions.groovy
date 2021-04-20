package br.com.pismo.casepismo.exceptions

import org.springframework.http.HttpStatus

class AccountExceptions {
    String message
    int status

    AccountExceptions(String message, int status){
        this.message = message
        this.status = status
    }
}
