package com.mczal.dialogflow.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.mczal.dialogflow.dto.v1.request.SimpleRequest
import com.mczal.dialogflow.dto.v1.request.WeatherParams
import com.mczal.dialogflow.dto.v1.response.SimpleResponse
import com.mczal.dialogflow.model.Intent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/dialogflow")
class ApiController {

  private val logger = LoggerFactory.getLogger(this::class.java)

  @Autowired
  private lateinit var jacksonMapper: ObjectMapper

  @PostMapping("",
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces= [MediaType.APPLICATION_JSON_VALUE]
  )
  fun handleRequest(@RequestBody content: SimpleRequest): ResponseEntity<SimpleResponse>{
    logger.warn(">>>>> content request: ${jacksonMapper.writeValueAsString(content)}")
    logger.warn(">>>>> content parameter: ${content.getParameters()}")

    val paramValues = getParameterValues(
      content.getIntentName(),
      content.getParameters()
    )

    val stringifiedParams = paramValues.map { entry ->
      "${entry.key} = ${entry.value}"
    }.joinToString(", ")

    val response = "The weather for $stringifiedParams is MCZAL"
    return ResponseEntity.ok(
      SimpleResponse(
        speech = response,
        displayText = response
      )
    )
  }

  fun getParameterValues(intent: String, parameters: String): Map<String, String>{
    when (intent) {
      Intent.WEATHER.member -> {
        val weatherParams = jacksonMapper.readValue(parameters, WeatherParams::class.java)
        return mapOf(
          Pair("date", weatherParams.date),
          Pair("geo-city", weatherParams.geo_city)
        )
      }
      else -> return emptyMap()
    }
  }

}