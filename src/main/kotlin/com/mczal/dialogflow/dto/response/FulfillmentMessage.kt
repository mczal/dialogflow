package com.mczal.dialogflow.dto.response

import com.mczal.dialogflow.dto.response.fulfillment.FulfillmentText

data class FulfillmentMessage(
  var text: FulfillmentText? = null
)
