package ru.rehtang.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "cryptocurrencyFeingClient", url = "\${openWeatherApi.feign.url}")
interface CryptocurrencyFeignClient {
  @GetMapping("/weather")
  fun receiveWeather(
      @RequestParam("q") city: String?,
      @RequestParam("appid") apiKey: String?,
      @RequestParam("lang") language: Language?,
      @RequestParam("units") metricSystem: MetricSystem?
  ): ApiResponseDto
  @GetMapping("/weather")
  fun receiveWeather(
      @RequestParam("q") city: String?,
      @RequestParam("appid") apiKey: String?,
      @RequestParam("lang") language: Language?,
      @RequestParam("units") metricSystem: MetricSystem?
  ): ApiResponseDto
  @GetMapping("/weather")
  fun receiveWeather(
      @RequestParam("q") city: String?,
      @RequestParam("appid") apiKey: String?,
      @RequestParam("lang") language: Language?,
      @RequestParam("units") metricSystem: MetricSystem?
  ): ApiResponseDto
  @GetMapping("/weather")
  fun receiveWeather(
      @RequestParam("q") city: String?,
      @RequestParam("appid") apiKey: String?,
      @RequestParam("lang") language: Language?,
      @RequestParam("units") metricSystem: MetricSystem?
  ): ApiResponseDto
}
