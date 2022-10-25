package ru.rehtang.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.rehtang.dto.BybitDto
import ru.rehtang.dto.bybit.BybitSymbolsDto

@FeignClient(name = "BybitFeingClient", url = "\${feign.bybit.url}")
interface BybitFeignClient {
    @GetMapping("/linear/index-price-kline")
    fun receiveBybit(
        @RequestParam("symbol") currencySymbol: String,
        @RequestParam("interval") interval: String,
        @RequestParam("from") date: Long? = System.currentTimeMillis(),
        @RequestParam("limit") limit: Int,
    ): BybitDto

    @GetMapping("/symbols")
    fun receiveSymbols(): BybitSymbolsDto
}
