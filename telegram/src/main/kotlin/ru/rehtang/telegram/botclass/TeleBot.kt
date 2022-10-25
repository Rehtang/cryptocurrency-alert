package ru.rehtang.telegram.botclass

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.rehtang.telegram.kafka.consumer.KafkaConsumer

@Service
class TeleBot : TelegramLongPollingBot() {
//    @Value("\${telegram.token}")
    private val botToken: String = "5674163812:AAFPt0F47QD6p2DquIYTufJ4Z3kZX29z-Q0"

//    @Value("\${telegram.username}")
    private val botUsername: String = "RehtangCryptocurrencyAlertBot"

    override fun getBotToken(): String = botToken

    override fun getBotUsername(): String = botUsername

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val message = update.message
            val chatId = message.chatId
            val responseText = if (message.hasText()) {
                val messageText = message.text
                when {
                    messageText == "/start" -> "Добро пожаловать!"
                    messageText.startsWith( "/start") -> "Добро пожаловать!"
                    messageText.startsWith("Кнопка ") -> "Вы нажали кнопку"
                    messageText.startsWith("Ультимативно") -> "Сынок, меняй штаны!"
//                    messageText.startsWith("/consume") ->
                    else -> "Вы написали: *$messageText*"
                }
            } else {
                "Я понимаю только команды"
            }
            sendNotification(chatId, responseText)
        }
    }

    private fun sendNotification(chatId: Long, responseText: String) {
        val responseMessage = SendMessage(chatId.toString(), responseText)
        responseMessage.setParseMode("Markdown")
        responseMessage.replyMarkup = getReplyMarkup(
            listOf(
                listOf("/start"), listOf("/consume", "Кнопка 2"), listOf("Кнопка 3", "Кнопка 4"), listOf("Ультимативно посрать")
            )
        )
        execute(responseMessage)
    }

    private fun getReplyMarkup(allButtons: List<List<String>>): ReplyKeyboardMarkup {
        val markup = ReplyKeyboardMarkup()
        markup.keyboard = allButtons.map { rowButtons ->
            val row = KeyboardRow()
            rowButtons.forEach { rowButton -> row.add(rowButton) }
            row
        }
        return markup
    }

}


