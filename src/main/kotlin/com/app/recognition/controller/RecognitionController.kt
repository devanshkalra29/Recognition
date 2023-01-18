package com.app.recognition.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RecognitionController {

    private val log: Logger = LoggerFactory.getLogger(RecognitionController::class.java)

    @GetMapping("/hello")
    fun helloWorld() : String {
        log.info("I have hit the endpoint")
        return "HelloWorld"
    }
}