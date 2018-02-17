package com.mczal.dialogflow.dto.response

import com.mczal.dialogflow.dto.response.fulfillment.FulfillmentText

data class DataResponse(
  var fulfillmentText: String = "",
  var fulfillmentMessages: FulfillmentText,
  var source: String = "",
  var payload: String = ""
)