package com.app.recognition.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RecognitionController {

    @GetMapping("/hello")
    fun helloWorld() : String {
        return "HelloWorld"
    }
}