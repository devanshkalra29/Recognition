package com.app.recognition.controller

import com.app.recognition.service.S3BucketService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class S3Controller (val s3BucketService : S3BucketService) {

    @PostMapping("/upload")
    fun uploadPicture(@RequestParam("fileName") fileName: String) =
        s3BucketService.uploadFile(fileName)
}