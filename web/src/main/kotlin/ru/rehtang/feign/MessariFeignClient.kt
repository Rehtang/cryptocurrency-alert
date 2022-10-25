package ru.rehtang.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import ru.rehtang.dto.MessariDto

@FeignClient(name = "MessariFeignClient", url = "\${feign.messari.url}")
interface MessariFeignClient {
  @GetMapping("{symbol}/metrics") fun receiveMessari(@PathVariable symbol: String?): MessariDto
}
