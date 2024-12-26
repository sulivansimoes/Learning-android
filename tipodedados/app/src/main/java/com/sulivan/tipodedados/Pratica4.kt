package com.sulivan.tipodedados

/**
 * controle de fluxo
 * */

fun main(){

    /**
     * condicionais
     * */
    val diaDaSemana:Int = 2

    //Estrutura de switch case
    //O -> representa o retorno
    val nomeDiaDaSemana = when(diaDaSemana){
        1 -> "segunda-feira"
        2 -> "terca-feira"
        3 -> "quarta-feira"
        4 -> "quinta-feira"
        5 -> "sexta-feira"
        else -> "final de semana";
    }
    println("dia da semana eh $nomeDiaDaSemana");

    fazerLogin("admin","admin123")
    fazerLogin("admin","admin1234")
    fazerLogin("user","senha")

    /**
     * repetição
     */
    var contador = 0;
    while(contador < 5){
        println(contador);
        contador++;
    }

    val frutas = listOf("banana, pera, melancia, laranja");
    for(fruta in frutas){
        println(fruta);
    }
}

fun fazerLogin(usuario:String, senha:String){
    if (usuario == "admin" && senha == "admin123"){
        println("usuario fez login")
    }else if (usuario == "admin"){
        println("senha incorreta")
    }else{
        println("usuario e senha incorreta")
    }

}