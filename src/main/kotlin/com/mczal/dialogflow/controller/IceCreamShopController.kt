package com.mczal.dialogflow.controller

import com.mczal.dialogflow.dto.v1.request.IceCreamShopContextRequest
import com.mczal.dialogflow.dto.v1.request.SimpleRequest
import com.mczal.dialogflow.dto.v1.response.SimpleResponse
import com.mczal.dialogflow.helper.Converter
import com.mczal.dialogflow.service.OrderService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/dialogflow/ice-cream-shop")
class IceCreamShopController {

  private val logger = LoggerFactory.getLogger(this::class.java)

  @Autowired
  private lateinit var orderService: OrderService

  @PostMapping("",
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces= [MediaType.APPLICATION_JSON_VALUE]
  )
  fun requestHandler(@RequestBody request: SimpleRequest<IceCreamShopContextRequest>): ResponseEntity<SimpleResponse> {
    val order = Converter.convertSimpleRequestToOrder(request)
    logger.warn("[ICE-SHOP][ORDER] $order")

    orderService.saveOrder(order)

    val response = request.result.fulfillment.speech
    return ResponseEntity.ok(SimpleResponse(speech = response, displayText = response))
  }
}