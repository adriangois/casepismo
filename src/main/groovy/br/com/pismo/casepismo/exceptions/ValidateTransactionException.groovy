package br.com.pismo.casepismo.exceptions

class ValidateTransactionException extends Exception{

    String message
    int status
    ValidateTransactionException(String msg, int status){
        this.message = msg
        this.status = status

    }
}
