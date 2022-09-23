package ru.rehtang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CryptocurrencyAlertApp {
  fun main(args: Array<String>) {
    runApplication<CryptocurrencyAlertApp>(*args)
  }
}
