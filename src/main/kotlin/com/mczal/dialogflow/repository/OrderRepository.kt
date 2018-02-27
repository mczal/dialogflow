package com.mczal.dialogflow.repository

import com.mczal.dialogflow.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, String> {
}