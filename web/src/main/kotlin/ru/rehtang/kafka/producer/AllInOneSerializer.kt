package ru.rehtang.kafka.producer

import com.fasterxml.jackson.module.kotlin.jsonMapper
import org.apache.kafka.common.serialization.Serializer
import ru.rehtang.dto.AllInOneDto

class AllInOneSerializer : Serializer<AllInOneDto> {
  override fun serialize(topic: String, data: AllInOneDto?): ByteArray? {
    if (data == null) return null
    return jsonMapper().writeValueAsBytes(data)
  }

  override fun close() {}
  override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}
