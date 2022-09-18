package ru.rehtang.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class TickDto(
    @JsonProperty("id") var id: Long? = null,
    @JsonProperty("ts") var timestamp: Integer? = null,
    @JsonProperty("data") var data: List<DataDto>? = null
)

data class DataDto(
    @JsonProperty("id") var id: Integer? = null,
    @JsonProperty("ts") var tradeTimeStamp: Integer? = null,
    @JsonProperty("trade-id") var tradeId: Integer? = null,
    @JsonProperty("a,ount") var amount: Float? = null,
    @JsonProperty("price") var price: Float? = null,
    @JsonProperty("direction") var direction: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class HuobiDto(
    @JsonProperty("ch") var narketName: String? = null,
    @JsonProperty("status") var status: String? = null,
    @JsonProperty("ts") var time: Long? = null,
    @JsonProperty("tick") var tick: TickDto? = null,
)
