package com.mczal.dialogflow

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DialogflowApplication

fun main(args: Array<String>) {
    SpringApplication.run(DialogflowApplication::class.java, *args)
}
