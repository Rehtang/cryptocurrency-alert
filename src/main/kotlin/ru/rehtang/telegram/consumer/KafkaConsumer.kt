package ru.rehtang.telegram.consumer

import org.jvnet.hk2.annotations.Service
import org.springframework.kafka.annotation.KafkaListener
import ru.rehtang.dto.AllInOneDto

@Service
class KafkaConsumer {
  @KafkaListener(topics = ["demo-topic"], groupId = "\${kafka.producer.client-id}")
  fun consume(message: AllInOneDto) {
    println("message received from topic : $message")
  }
}
