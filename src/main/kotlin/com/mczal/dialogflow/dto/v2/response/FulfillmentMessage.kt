package com.mczal.dialogflow.dto.v2.response

import com.mczal.dialogflow.dto.v2.response.fulfillment.FulfillmentText

data class FulfillmentMessage(
  var text: FulfillmentText? = null
)
