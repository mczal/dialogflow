package com.mczal.dialogflow.dto.v1.request

data class IceCreamShopContextRequest(
  var name: String = "",
  var lifespan: Int = 0,
  var parameters: IceCreamShopParameter? = null
)

data class IceCreamShopParameter(
  var size: String = "",
  var flavour: String = "",
  var paymentMethods: String = ""
)

