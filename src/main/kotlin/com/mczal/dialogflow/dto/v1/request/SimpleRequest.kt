package com.mczal.dialogflow.dto.v1.request

import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*
import kotlin.collections.ArrayList

data class SimpleRequest(
  var id: String = "",
  var timestamp: Date? = null,
  var lang: String = "",
  var result: Result = Result(),
  var status: Status = Status(),
  var sessionId: String = ""
){

  fun getIntentName(): String{
    return result.metadata.intentName
  }

  fun getParameters(): String{
    return mapper().writeValueAsString(result.parameters)
  }

  private fun mapper(): ObjectMapper{
    return ObjectMapper()
  }

}

data class Status(
  var code: Int = 0,
  var errorType: String = "",
  var webhookTimedOut: Boolean = false
)

data class Result(
  var source: String = "",
  var resolvedQuery: String = "",
  var speech: String = "",
  var action: String = "",
  var actionIncomplete: Boolean = true,
  var parameters: Any = Any(),
  var contexts: Any? = null,
  var metadata: Metadata = Metadata(),
  var fulfillment: Fulfillment = Fulfillment(),
  var score: Double = 0.0
)

data class Metadata(
  var intentId: String = "",
  var webhookUsed: Boolean = false,
  var webhookForSlotFillingUsed: Boolean = false,
  var intentName: String = ""
)

data class Fulfillment(
  var speech: String = "",
  var messages: List<Message> = ArrayList()
)

data class Message(
  var type: Int = 0,
  var speech: String = ""
)

