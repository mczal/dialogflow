package com.mczal.dialogflow.dto.v1.request

import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherParams(
  var date: String = "",

  @JsonProperty("geo-city")
  var geo_city: String = ""
)