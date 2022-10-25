package ru.rehtang.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.rehtang.dto.HuobiDto
import ru.rehtang.dto.huobi.HuobiSymbolsDto

@FeignClient(name = "HuobiFeignClient", url = "\${feign.huobi.url}")
interface HuobiFeignClient {
    @GetMapping("/trade")
    fun receiveHuobi(@RequestParam("symbol") symbol: String): HuobiDto
    @GetMapping("/trade")
    fun receiveSymbols(): HuobiSymbolsDto

}
