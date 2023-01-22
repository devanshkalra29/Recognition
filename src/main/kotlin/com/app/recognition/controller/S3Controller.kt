package com.app.recognition.controller

import com.app.recognition.service.S3BucketService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class S3Controller (val s3BucketService : S3BucketService) {

    private val log: Logger = LoggerFactory.getLogger(S3Controller::class.java)

    @PostMapping("/upload")
    fun uploadPicture(@RequestParam("fileName") fileName: String) =
        s3BucketService.uploadFile(fileName)
}