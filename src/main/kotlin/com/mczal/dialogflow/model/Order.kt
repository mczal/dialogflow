package com.mczal.dialogflow.model

import javax.persistence.*

@Entity
@Table(name = "`order`")
data class Order(

  @Id
  @GeneratedValue
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