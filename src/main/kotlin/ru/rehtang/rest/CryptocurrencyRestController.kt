package ru.rehtang.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.rehtang.dto.BybitDto
import ru.rehtang.dto.HuobiDto
import ru.rehtang.dto.MessariDto
import ru.rehtang.service.CryptocurrencyProvideService

@RestController
@RequestMapping
class CryptocurrencyRestController(private val service: CryptocurrencyProvideService) {
  @GetMapping("/bybit")
  fun getBybitMarket(
      @RequestParam symbol: String,
      @RequestParam interval: String,
      @RequestParam limit: Int
  ): BybitDto {
    return service.receiveBybitMarket(symbol, interval, limit)
  }
  @GetMapping("/messari")
  fun   getMessariMarket(@RequestParam symbol: String): MessariDto {
    return service.receiveMessariMarket(symbol)
  }
  @GetMapping("/huobi")
  fun getHuobiMarket(@RequestParam symbol: String): HuobiDto {
    return service.receiveHuobiMarket(symbol)
  }
}
