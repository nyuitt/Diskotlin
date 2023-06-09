package pexisbot

import dev.kord.core.*
import dev.kord.core.entity.*
import dev.kord.core.event.message.*
import dev.kord.core.event.Event
import dev.kord.core.event.message.ReactionAddEvent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.gateway.Intent
import kotlinx.coroutines.delay
import io.github.cdimascio.dotenv.dotenv

val  dotenv = dotenv()
val textos = mutableListOf<String>()
val sim = ReactionEmoji.Unicode("\u2705")
val não = ReactionEmoji.Unicode("\u274C")

suspend fun main() {
    val kord = Kord(dotenv["TOKEN"])
    val pingPong = ReactionEmoji.Unicode("\uD83C\uDFD3")


    kord.on<MessageCreateEvent> {
        if (message.content != "!ping") return@on

        val response = message.channel.createMessage("Pong!")
        response.addReaction(pingPong)

        delay(5000)
        message.delete()
        response.delete()




    }

    kord.on<MessageCreateEvent> {
        if (message.content != "!curiosidade") return@on
        curiosidade(message)


    }

    kord.on<MessageCreateEvent> {
        if (message.content != "!info") return@on
        info(message)


    }

//    kord.on<MessageCreateEvent> {
//        if (message.content != "!enquete") return@on
//        val mensagemSplit = message.content.split(" ")
//        enquete(mensagemSplit, message)
//
//
//    }


    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}

val curiosidades = listOf(
    "A PXA possui uma equipe de desenvolvimento trabalhando em novas atualizações para o PEXISBOT",
    "A PXA é conhecida como PEXISA, uma extensão do seu nome original. Pe.Xi.sA",
    "PXA nasceu dia 16/01/2022",
    "A PXA possui um twitter oficial: https://twitter.com/pexisajogahj",
    "A PXA no mesmo dia em que nasceu, amassou 3 games seguidos no clash:)"
)

suspend fun curiosidade(mensagemDados: Message){
    println("Função curiosidade chamada")
    val curiosidade = curiosidades.random()
    mensagemDados.channel.createMessage(curiosidade)
}

//suspend fun enquete(mensagemSplit: List<String>, mensagemDados: Message){
//    if (mensagemSplit.size < 2){
//        mensagemDados.channel.createMessage("Envie o comando na maneira correta, colocando !enquete [nome da enquete]")
//        return
//    }
//    println("POST IF")
//
//    val enquete = mensagemSplit.subList(1, mensagemSplit.size).joinToString(" ")
//    val resposta = mensagemDados.channel.createMessage("Iniciando enquete: $enquete")
//    println("$enquete")
//
//    resposta.addReaction(sim)
//    resposta.addReaction(não)
//    println("POST REACTION")
//}

suspend fun info(mensagemDados: Message){
    println("INFO chamado")

      mensagemDados.channel.createMessage("**!!IMPORTANTE!!**\n" +
            "\n" +
            "O **PEXISBOT** é um projeto individual sem fins lucrativos, construido e idealizado por @nyuitt com o apoio de colaboradores (@pexisajogahj para mais informações).\n" +
            "\n" +
            "O projeto está em constante desenvolvimento e as funções e comandos podem sofrer alterações no futuro.\n" +
            "\n" +
            "Comandos atuais disponíveis:\n" +
            "\n" +
            "!info -> exibe informações sobre o PEXISBOT\n" +
            "!curiosidade -> apresenta uma curiosidade aleatória sobre a PXA\n" +
            "!ping -> simplesmente \"pingpong\" da pexisa.")


}


