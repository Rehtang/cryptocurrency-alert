package ru.rehtang.kafka.producer

import java.util.*
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.rehtang.dto.AllInOneDto

@RestController
@RequestMapping("/produce")
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, Any>) {

  @PostMapping("/message")
  fun sendMessage(@RequestBody message: AllInOneDto): String {
    var key = UUID.randomUUID().toString()

    try {
      kafkaTemplate.send("demo-topic", key, message) // опик в конфиг
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return "json message sent successfully"
  }
}
