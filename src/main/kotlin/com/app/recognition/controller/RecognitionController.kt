package com.app.recognition.controller

import com.app.recognition.service.S3BucketService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecognitionController (val s3BucketService : S3BucketService) {



    private val log: Logger = LoggerFactory.getLogger(RecognitionController::class.java)

    @GetMapping("/hello")
    fun helloWorld() : String {
        log.info("I have hit the endpoint")
        return "HelloWorld"
    }

    @PostMapping("/upload")
    fun uploadPicture(@RequestParam("fileName") fileName: String)  {
        s3BucketService.uploadFile(fileName)
    }
}