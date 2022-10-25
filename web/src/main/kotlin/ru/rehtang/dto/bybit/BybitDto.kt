package ru.rehtang.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BybitDto(@JsonProperty("result") var result: List<ResultDto>? = null)

data class ResultDto(
    @JsonProperty("symbol") var symbol: String? = null,
    @JsonProperty("period") var period: String? = null,
    @JsonProperty("open_time") var startAt: Int? = null,
    @JsonProperty("open") var open: String? = null,
    @JsonProperty("high") var high: String? = null,
    @JsonProperty("low") var low: String? = null,
    @JsonProperty("close") var close: String? = null
)
