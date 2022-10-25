package ru.rehtang.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class StatusDto(@JsonProperty("timestamp") var timestamp: String? = null)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MessariDto(
    @JsonProperty("status") var status: StatusDto?,
    @JsonProperty("data") var data: MessariDataDto?
)

data class MessariDataDto(
    @JsonProperty("slug") var slug: String?,
    @JsonProperty("market_data") var marketData: MarketDataDto?
)

data class MarketDataDto(
    @JsonProperty("price_usd") var usdPrice: Double? = null,
    @JsonProperty("price_btc") var btcPrice: Double? = null,
    @JsonProperty("real_volume_last_24_hours") var realTradeVolume: Double? = null,
    @JsonProperty("percent_change_usd_last_24_hours") var usdPercentChange: Double? = null,
    @JsonProperty("percent_change_btc_last_24_hours") var btcPercentChange: Double? = null,
    @JsonProperty("ohlcv_last_1_hour") var lastHourTrades: OhlcvDto? = null,
)

data class OhlcvDto(
    @JsonProperty("open") var openPrice: Double? = null,
    @JsonProperty("high") var highPrice: Double? = null,
    @JsonProperty("low") var lowPrice: Double? = null,
    @JsonProperty("close") var closePrice: Double? = null,
    @JsonProperty("volume") var volume: Double? = null,
)
