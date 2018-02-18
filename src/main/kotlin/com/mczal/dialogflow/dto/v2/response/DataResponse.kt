package com.mczal.dialogflow.dto.v2.response

import com.mczal.dialogflow.dto.v2.response.fulfillment.FulfillmentText

data class DataResponse(
  var fulfillmentText: String = "",
  var fulfillmentMessages: FulfillmentText,
  var source: String = "",
  var payload: String = ""
)