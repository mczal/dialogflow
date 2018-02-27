package com.mczal.dialogflow.controller

import com.mczal.dialogflow.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class AdminController {

  @Autowired
  private lateinit var orderService: OrderService

  @GetMapping(value = [""])
  fun index(model: Model): String{
    model.addAttribute("orders", orderService.listAll())
    return "index"
  }

}