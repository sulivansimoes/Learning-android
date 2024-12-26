package com.sulivan.tipodedados

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * Programação assincrona com o coroutine
 */


//declaracao de funcao assicrona
suspend fun doSomething(delayTime: Long, message:String){
    delay(delayTime)
    println(message)
    return
}

fun main() {

    //Para acionar uma funcao assincrona é necessario que ela esteja
    //com escopo assincrono. O GlobalScope fornece isso, mas existem outros tipos
    //de escopos mais complexos
    val job1 = GlobalScope.launch {
        doSomething(2000,"Tarefa 1 completa")
    }

    val job2 = GlobalScope.launch {
        doSomething(1500,"Tarefa 2 completa")
    }

    val job3 = GlobalScope.launch {
        doSomething(1000,"Tarefa 3 completa")
    }

    //Thread de lançamento das funções assincronas
    runBlocking {
        job1.join()
        job2.join()
        job3.join()
    }
}