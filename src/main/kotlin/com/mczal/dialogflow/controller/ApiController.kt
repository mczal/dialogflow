package com.mczal.dialogflow.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.mczal.dialogflow.dto.request.DataRequest
import com.mczal.dialogflow.dto.response.DataResponse
import com.mczal.dialogflow.dto.response.fulfillment.FulfillmentText
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
  fun handleRequest(@RequestBody content: DataRequest): ResponseEntity<DataResponse>{
    logger.warn(">>>>> content request: ${jacksonMapper.writeValueAsString(content)}")

    return ResponseEntity.ok(
      DataResponse(
        fulfillmentText = "This Is Fulfillment Text",
        fulfillmentMessages = FulfillmentText(text = listOf("List 1","List 2")),
        payload = "Payload",
        source = "Source"
      )
    )
  }

}