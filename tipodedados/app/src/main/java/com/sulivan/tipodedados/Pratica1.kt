//declaração de criação do pacote atual
package com.sulivan.tipodedados

/**
 * Tipos de dados básicos do kotlin e  null safety
 */
fun main(){

    //Variaveis mutaveis
    var idade: Int = 90;
    idade = 25

    //variaveis imutaveis (constantes)
    val nome:String = "Jubscleison"

    //Tipos de dados
    var numeroInteiro:Int = 10;
    var numeroDouble:Double = 9.99;
    var numeroFload:Float = 9f;
    var isBoolean:Boolean = true;
    var texto:String = "meu texto"
    var array:Array<Int> = arrayOf(0,1,2,3,4);

    //Também é possível usar o tipo implicito, ou seja, não informar o tipo na declaração
    var texto2 = "declaração implicita";

    //Tratamento de null safety
    val nullableString1:String ?= null;// o ? indica que variavel pode ser null
    println(nullableString1);

    var nullableString2:String ?= null;// usando um default caso seja null
    println(nullableString2?.length ?: 0);
    nullableString2 = "texto";
    println(nullableString2?.length ?: 0);

    var nullableString3:String ?= null ;//
    println(nullableString3!!.length); //o ! indica que variavel NÃO pode ser null. Ou seja, esse trecho da null exception
    nullableString3 = "nao esta null";
    println(nullableString3!!.length);

}