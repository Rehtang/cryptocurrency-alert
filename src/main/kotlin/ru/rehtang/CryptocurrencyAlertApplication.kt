package ru.rehtang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CryptocurrencyAlertApplication {
  fun main(args: Array<String>) {
    runApplication<CryptocurrencyAlertApplication>(*args)
  }
}
