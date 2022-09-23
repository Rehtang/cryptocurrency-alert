package ru.rehtang.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.rehtang.dto.HuobiDto

@FeignClient(name = "HuobiFeignClient", url = "\${CryptocurrencyAlertApplication.feign.huobi.url}")
interface HuobiFeignClient {
  @GetMapping("") fun receiveHuobi(@RequestParam("symbol") symbol: String): HuobiDto
}
