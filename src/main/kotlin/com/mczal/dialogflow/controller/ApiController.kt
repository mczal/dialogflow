package com.mczal.dialogflow.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.mczal.dialogflow.dto.v1.response.SimpleResponse
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
  fun handleRequest(@RequestBody content: Any): ResponseEntity<SimpleResponse>{
    logger.warn(">>>>> content request: ${jacksonMapper.writeValueAsString(content)}")

    val response = "This is a sample response from your webhook!"
    return ResponseEntity.ok(
      SimpleResponse(
        speech = response,
        displayText = response
      )
    )
  }

}