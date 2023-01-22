package com.app.recognition.service

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder
import com.amazonaws.services.rekognition.model.DetectLabelsRequest
import com.amazonaws.services.rekognition.model.Image
import com.app.recognition.controller.RekognitionController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.nio.ByteBuffer

@Service
class RekognitionService(
    @Value("\${aws.credentials.accessKey}") val accessKey: String,
    @Value("\${aws.credentials.secretKey}") val secretKey: String,
) {
    private val log: Logger = LoggerFactory.getLogger(RekognitionController::class.java)
    fun detectLabels(fileName: String) =
        try {
            log.info("starting upload process")
            val credentials = BasicAWSCredentials(accessKey, secretKey)
            val bytes = File(fileName).readBytes()
            val buffer = ByteBuffer.wrap(bytes)


            val rekognitionClient = AmazonRekognitionClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(AWSStaticCredentialsProvider(credentials))
                .build()

            val request = DetectLabelsRequest().withImage(Image().withBytes(buffer))
            val result = rekognitionClient.detectLabels(request)

            log.info("$result")

            log.info("upload complete!!")
        } catch (e: Exception) {
            e.printStackTrace()
            log.error("File upload failed", e)
        }
}