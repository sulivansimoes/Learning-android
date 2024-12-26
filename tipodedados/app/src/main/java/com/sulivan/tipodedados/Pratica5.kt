package com.sulivan.tipodedados

/***
 * Orientação a objetos
 */

//Declaracao de interface
interface Alimentavel{
    fun comer();
}

//Declaracao de classe abstrata implementando interface
abstract class Animal(
    public val nome : String
) : Alimentavel {
    abstract fun emitirSom();
}

//Classes que implementam classe abstrata
class Cachorro(nome:String): Animal(nome){
    override fun emitirSom() {
        println("$nome latiu")
    }

    override fun comer() {
        println("$nome comeu")
    }

    fun passear(){
        println("$nome passeou")
    }

}

class Gato(nome:String): Animal(nome) {
    override fun emitirSom() {
        println("$nome miou")
    }

    override fun comer() {
        println("$nome comeu")
    }
}

fun main(){
    val cachorro:Cachorro = Cachorro("lulu")
    val gato:Gato = Gato("bob")

    cachorro.comer()
    cachorro.emitirSom()
    cachorro.passear()

    gato.comer()
    gato.emitirSom()
}



