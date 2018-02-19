package com.mczal.dialogflow.dto.v1.request

import java.util.*
import kotlin.collections.ArrayList

data class SimpleRequest<P>(
  var id: String = "",
  var timestamp: Date? = null,
  var lang: String = "",
  var result: P? = null,
  var status: Status? = null,
  var sessionId: String = ""
)

data class Status(
  var code: Int = 0,
  var errorType: String = "",
  var webhookTimedOut: Boolean = false
)

private data class Result<P>(
  var source: String = "",
  var resolvedQuery: String = "",
  var speech: String = "",
  var action: String = "",
  var actionIncomplete: Boolean = true,
  var parameters: P? = null,
  var contexts: Any? = null,
  var metadata: Metadata? = null,
  var fulfillment: Fulfillment? = null,
  var score: Double = 0.0
)

private data class Metadata(
  var intentId: String = "",
  var webhookUsed: Boolean = false,
  var webhookForSlotFillingUsed: Boolean = false,
  var intentName: String = ""
)

private data class Fulfillment(
  var speech: String = "",
  var messages: List<Message> = ArrayList()
)

private data class Message(
  var type: Int = 0,
  var speech: String = ""
)

