package com.app.recognition.controller

import com.app.recognition.service.RekognitionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RekognitionController(val rekognitionService: RekognitionService) {
    @PostMapping("/labels")
    fun detectLabels(@RequestParam("fileName") fileName: String) =
        rekognitionService.detectLabels(fileName)
}