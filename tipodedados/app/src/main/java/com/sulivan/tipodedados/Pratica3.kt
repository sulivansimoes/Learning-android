package com.sulivan.tipodedados

/**
 * funções e lambda
 * */

fun main(){

    val number1:Int = 10;
    val number2:Int = 20;

    println(sum(number1,number2));

    println(multiply(number1,number2));

    //função lambda
    // o -> eh referente ao retorno
    val sum2 = { n1:Int, n2:Int -> n1+n2}

    //executando lambda
    println(sum2(number1,number2));

}

//Função comum
fun sum(number1: Int, number2: Int): Int{
    return number1 + number2;
}

//Sem definição de tipo
fun multiply(number1: Int, number2:Int) = number1 * number2;
