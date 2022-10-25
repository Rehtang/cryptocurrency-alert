/*
package ru.rehtang.telegram.commands.service

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

abstract class ServiceCommands(commandIdentifier: String?, description: String?) : BotCommand(
    commandIdentifier,
    description
) {
    override fun execute(absSender: AbsSender?, user: User?, chat: Chat?, arguments: Array<out String>?) {
//        var userName = if (user!!.userName != null) user!!.userName else java.lang.String.format(
//            "%s %s",
//            user!!.lastName,
//            user!!.firstName
//        )
        val builder:StringBuilder
        var answer: SendMessage
        answer.setChatId(chat?.id.toString())

    }

}*/
