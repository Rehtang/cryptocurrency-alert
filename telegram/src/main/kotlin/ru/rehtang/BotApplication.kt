package ru.rehtang.telegram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import ru.rehtang.telegram.botclass.TeleBot


@SpringBootApplication
class BotApplication

fun main(args: Array<String>) {
    var bot = TeleBot()
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
    telegramBotsApi.registerBot(bot)

    runApplication<BotApplication>(*args)

}
