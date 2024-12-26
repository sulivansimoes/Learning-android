
//declaração de criação do pacote atual
package com.sulivan.tipodedados

//Tipo de dados estruturados, ou seja, objetos
data class Pessoa(val nome:String, val idade: Int);

fun main(){

    //Lista de objetos
    val pessoas: List<Pessoa> = listOf(
        Pessoa("Helena", 25),
        Pessoa("Agatha", 33),
        Pessoa("Joyce",55),
        Pessoa("Marcos",65),
        Pessoa("Eva",21)
    );

    //Filtrar pessoas com idade maior que 25
    val pessoasMaioresDe25 = pessoas.filter { it.idade > 25 }
    println("Pessoas maiores que 25: $pessoasMaioresDe25")

    //Mapear apenas os nomes das pessoas
    val nomes = pessoas.map { it.nome }
    println("Apenas os nomes: $nomes")

    //Verificar se todas pessoas são maiores que 20
    val todosSaoMaioresDe20 = pessoas.all { it.idade > 20 }
    println("Todos são maiores de 20? $todosSaoMaioresDe20")

    //Encontrando primeira pessoa com menos de 30
    val primeiroMenorDe30 = pessoas.find { it.idade < 30 }
    println("Primeira pessoa menor de 30: $primeiroMenorDe30")

    //Ordenando pessoas por idade em orde crescente.
    val pessoasOrdenadasPorIdade = pessoas.sortedBy { it.idade }
    println("Pessoas ordenadas por idade: $pessoasOrdenadasPorIdade")

    //Existe se existe uma pessoa chamada Helena na lista
    val nomeProcurado = "Joao"
    val existePessoa = pessoas.any { it.nome == nomeProcurado}
    println("Existe algum(a) $nomeProcurado ? $existePessoa")

    //Quantas pessoas tem idade maior que 30
    val quantidadeMaiorDe30 = pessoas.count{it.idade> 30}
    println("Quantas pessoas tem mais de 30? $quantidadeMaiorDe30")

    //Imprimir lista com string separada por virgula
    val nomesConcatenados = pessoas.joinToString (separator = ", "){it.nome}
    print("Nomes concatenados $nomesConcatenados")
}

