package pexisbot

import dev.kord.core.entity.*

suspend fun guardarTexto(mensagemSplit: List<String>, mensagemDados: Message){
    if (mensagemSplit.size < 2){
        mensagemDados.channel.createMessage("Envie o comando na maneira correta, colocando !guardar [texto]")
        return
    }
    println("Função reconhecida ")
    val texto = mensagemSplit.subList(1, mensagemSplit.size).joinToString(" ")
    textos.add(texto)

    mensagemDados.channel.createMessage("Mensagem salva!")
}