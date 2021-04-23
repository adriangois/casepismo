package br.com.pismo.casepismo.util

enum OperationsTypeEnum {

    A_VISTA(1), PARCELADA(2), SAQUE(3), PAGAMENTO(4)
    private value
    OperationsTypeEnum(int value) {
        this.value = value
    }

    int getValue(){
        this.value
    }

}
