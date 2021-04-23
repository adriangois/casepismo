package br.com.pismo.casepismo.exceptions

class AccountExceptions {
    String message
    int status

    AccountExceptions(String message, int status) {
        this.message = message
        this.status = status
    }
}
