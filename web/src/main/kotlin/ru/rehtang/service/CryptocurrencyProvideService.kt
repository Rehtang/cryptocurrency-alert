package ru.rehtang.service

import org.springframework.stereotype.Service
import ru.rehtang.dto.BybitDto
import ru.rehtang.dto.HuobiDto
import ru.rehtang.dto.MessariDto
import ru.rehtang.feign.BybitFeignClient
import ru.rehtang.feign.HuobiFeignClient
import ru.rehtang.feign.MessariFeignClient

@Service
class CryptocurrencyProvideService(
    private val bybitClient: BybitFeignClient,
    private val huobiFeignClient: HuobiFeignClient,
    private val messariClient: MessariFeignClient
) {
  fun receiveBybitMarket(symbol: String, interval: String, limit: Int): BybitDto {
    return bybitClient.receiveBybit(symbol, interval, System.currentTimeMillis() / 1000, limit)
  }
  fun receiveMessariMarket(symbol: String): MessariDto {
    return messariClient.receiveMessari(symbol)
  }
  fun receiveHuobiMarket(symbol: String): HuobiDto {
    return huobiFeignClient.receiveHuobi(symbol)
  }
}
