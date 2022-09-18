package ru.rehtang.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BybitDto(@JsonProperty("result") var result: List<ResultDto>? = null)

data class ResultDto(
    @JsonProperty("id") var id: Int? = null,
    @JsonProperty("symbol") var symbol: String? = null,
    @JsonProperty("period") var period: String? = null,
    @JsonProperty("start_at") var startAt: Int? = null,
    @JsonProperty("open") var open: Int? = null,
    @JsonProperty("high") var high: Int? = null,
    @JsonProperty("low") var low: Int? = null,
    @JsonProperty("close") var close: Int? = null
)
