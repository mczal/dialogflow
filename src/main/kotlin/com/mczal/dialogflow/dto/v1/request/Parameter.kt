package com.mczal.dialogflow.dto.v1.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

abstract class Params{
  abstract fun getMappedParams(stringParam: String): Map<String, String>

  protected fun jacksonMapper(): ObjectMapper{
    return ObjectMapper()
  }
}

data class WeatherParams(
  @JsonProperty("date")
  var date: String = "",

  @JsonProperty("geo-city")
  var geo_city: String = ""
): Params() {

  override fun getMappedParams(stringParam: String): Map<String, String> {
    val weatherParams = jacksonMapper().readValue(stringParam, this::class.java)

    return mapOf(
      Pair("date", weatherParams.date),
      Pair("geo-city", weatherParams.geo_city)
    )
  }
}

data class HeadlineParams(
  @JsonProperty("channel")
  var channel: String = ""

): Params() {

  override fun getMappedParams(stringParam: String): Map<String, String> {
    val headlineParams = jacksonMapper().readValue(stringParam, this::class.java)

    return mapOf(
      Pair("channel", headlineParams.channel)
    )
  }
}

data class BeritaParams(
  @JsonProperty("channel")
  var channel: String = ""

): Params() {

  override fun getMappedParams(stringParam: String): Map<String, String> {
    val beritaParams = jacksonMapper().readValue(stringParam, this::class.java)

    return mapOf(
      Pair("channel", beritaParams.channel)
    )
  }
}
