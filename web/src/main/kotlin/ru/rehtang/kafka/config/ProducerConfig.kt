package ru.rehtang.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer
import ru.rehtang.dto.AllInOneDto

@Configuration
@EnableKafka
class ProducerConfig {
    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        val configMap: MutableMap<String, Any> = HashMap()
        configMap[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        configMap[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configMap[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        configMap[JsonDeserializer.TRUSTED_PACKAGES] = "ru.rehtang"
        return DefaultKafkaProducerFactory(configMap)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }

    /*  @Bean
      fun consumerFactory(): ConsumerFactory<String, AllInOneDto> {
        val configMap: MutableMap<String, Any> = HashMap()
        configMap[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:8083"
        configMap[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configMap[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configMap[ConsumerConfig.GROUP_ID_CONFIG] = "\${kafka.producer.client-id}"
        configMap[JsonDeserializer.TRUSTED_PACKAGES] = "ru.rehtang"
        return DefaultKafkaConsumerFactory(configMap)
      }

      @Bean
      fun kafkaListenerContainerFactory():
          ConcurrentKafkaListenerContainerFactory<String, AllInOneDto> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, AllInOneDto>()
        factory.consumerFactory = consumerFactory()
        return factory
      }*/
}
