package com.app.recognition

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecognitionApplication

fun main(args: Array<String>) {
	val log: Logger = LoggerFactory.getLogger(RecognitionApplication::class.java)
	runApplication<RecognitionApplication>(*args)
	log.info("We have started")
}
