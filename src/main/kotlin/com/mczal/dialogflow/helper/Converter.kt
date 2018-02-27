package com.mczal.dialogflow.helper

import com.mczal.dialogflow.dto.v1.request.IceCreamShopContextRequest
import com.mczal.dialogflow.dto.v1.request.SimpleRequest
import com.mczal.dialogflow.model.Order

class Converter {
  companion object {
    fun convertSimpleRequestToOrder(request: SimpleRequest<IceCreamShopContextRequest>): Order{
      return Order(
        sessionId = request.sessionId,
        flavour = request.result.contexts.first().parameters!!.flavour,
        paymentMethod = request.result.contexts.first().parameters!!.paymentMethods,
        size = request.result.contexts.first().parameters!!.size
      )
    }
  }
}