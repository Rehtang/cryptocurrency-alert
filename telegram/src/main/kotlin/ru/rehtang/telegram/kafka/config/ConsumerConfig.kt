package ru.rehtang.telegram.kafka.config

import lombok.SneakyThrows
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class ConsumerConfig {
//    private val kafkaProperties: KafkaProperties? = null

    @Value("\${topics.telebot}")
    private val cryptoTopic: String = ""

/*
    @Value("\${news-storage.kafka-ssl-enabled}")
    private val kafkaSslEnabled = false
*/

    @Bean
    fun messageReceiver(): ConsumerFactory<String, Any> {
        return createConsumerFactory(Any::class.java, cryptoTopic)
    }

    @Bean("newsConsumerFactory")
    fun newsKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, Any> =
            ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = messageReceiver()
        return factory
    }

    @SneakyThrows
    private fun <T> createConsumerFactory(valueType: Class<T>, topic: String?): ConsumerFactory<String, T> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "\${kafka.consumer.bootstrap_servers}"
        props[ConsumerConfig.CLIENT_ID_CONFIG] = "\${kafka.consumer.client_id}-$topic"
        props[ConsumerConfig.GROUP_ID_CONFIG] = "ru.rehtang"
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "\${kafka.consumer.auto_offset_reset}"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java

        props[JsonDeserializer.USE_TYPE_INFO_HEADERS] = false
        props[JsonDeserializer.VALUE_DEFAULT_TYPE] = valueType

        return DefaultKafkaConsumerFactory(
            props, StringDeserializer(), JsonDeserializer(valueType)
        )
    }


}