package ru.rehtang.telegram.kafka.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

//import ru.rehtang.dto.AllInOneDto as AllInOneDto1

/*@Service
class KafkaConsumer(private val kafkaTemplate: KafkaTemplate<String, Any>) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${topics.telebot}"], groupId = "\${kafka.consumer.client-id}")
    fun consume(message: Any) {

        try {
            kafkaTemplate.receive("\${topics.telebot}",0,0)
            logger.info("message received from topic : $message")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}*/
@Component
class KafkaConsumer {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${topics.telebot}"], groupId = "ru.rehtang")
    fun consume(message: Any) {
        logger.info("Message received {}", message)
//        ack.acknowledge()
    }
}
