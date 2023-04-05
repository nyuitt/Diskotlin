package pexisbot

import dev.kord.core.entity.*

suspend fun mostrarTextos(mensagemDados: Message){
    val textosString = textos.joinToString(", ")
    mensagemDados.channel.createMessage("As mensagens que foram guardadas são: $textosString")
}