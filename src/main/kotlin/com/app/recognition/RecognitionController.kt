package com.app.recognition

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RecognitionController {

    @GetMapping("/hello")
    fun hello() = "hello"
}