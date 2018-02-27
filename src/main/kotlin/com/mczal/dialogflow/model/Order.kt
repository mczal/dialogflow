package com.mczal.dialogflow.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "`order`")
data class Order(

  @Id
  var id: Int = 0,

  @Column(name = "sessionId")
  var sessionId: String = "",

  @Column(name = "flavour")
  var flavour: String = "",

  @Column(name = "size")
  var size: String = "",

  @Column(name = "paymentMethod")
  var paymentMethod: String = "",

  @Column(name = "orderNumber")
  var orderNumber: String = ""
)