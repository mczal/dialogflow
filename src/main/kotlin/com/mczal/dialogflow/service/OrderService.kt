package com.mczal.dialogflow.service

import com.mczal.dialogflow.model.Order

interface OrderService {
  fun saveOrder(order: Order)
  fun listAll(): List<Order>
}