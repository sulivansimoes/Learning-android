package com.sulivan.calculadora

class Calculadora {

    /**
     * companion object funciona de forma analoga a metodos Static no java
     * ou seja, tudo que está dentro de companion object pertence a classe
     * e não ao objeto
     */
    companion object {

        fun soma(a:Int, b:Int) = a + b;
        fun subtrai(a:Int, b:Int) = a - b;
        fun multiplica(a:Int, b:Int) = a * b;
        fun divide(a:Int, b:Int) = a / b;
    }
}