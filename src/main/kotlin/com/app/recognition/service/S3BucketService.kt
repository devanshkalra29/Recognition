package com.app.recognition.service

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.PutObjectRequest
import com.app.recognition.controller.RecognitionController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File

@Service
class S3BucketService {

    @Value("\${aws.credentials.accessKey}")
    lateinit var accessKey : String

    @Value("\${aws.credentials.secretKey}")
    lateinit var secretKey : String

    @Value("\${aws.s3.bucket}")
    lateinit var bucket : String

    private val log: Logger = LoggerFactory.getLogger(RecognitionController::class.java)

    fun uploadFile(fileName: String) {

        try {
            log.info("starting upload process")
            val credentials = BasicAWSCredentials(accessKey, secretKey)
             val s3Client: AmazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                 .withCredentials(AWSStaticCredentialsProvider(credentials))
                .build()

            val file = File(fileName)

            val putObjectRequest = PutObjectRequest(bucket, file.name, file)

            s3Client.putObject(putObjectRequest)

            log.info("upload complete!!")

        } catch (e: Exception) {
            e.printStackTrace()
            log.error("File upload failed", e)
        }
    }
}