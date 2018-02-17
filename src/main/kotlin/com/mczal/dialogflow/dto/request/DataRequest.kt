package com.mczal.dialogflow.dto.request

data class DataRequest(
  var session: String = "",
  var requestId: String = "",
  var queryResult: Any = "",
  var originalDetectIntentRequest: Any = Any()
)
