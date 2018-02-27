package com.mczal.dialogflow.service.impl

import com.mczal.dialogflow.model.Order
import com.mczal.dialogflow.repository.OrderRepository
import com.mczal.dialogflow.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class OrderServiceimpl: OrderService {

  @Autowired
  private lateinit var orderRepository: OrderRepository

  @Transactional(readOnly = false)
  override fun saveOrder(order: Order) {
    order.orderNumber = generateOrderNumber(order.sessionId)
    orderRepository.save(order)
  }

  private fun generateOrderNumber(sessionId: String): String {
    return "${Date().time}|$sessionId"
  }
}