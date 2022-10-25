package ru.rehtang.dto.huobi

data class HuobiSymbolsDto(
    var data: List<Symbol>
)

data class Symbol(
    var symbol: String
)