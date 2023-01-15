package com.app.recognition

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@ComponentScan( basePackages = ["com.app.recognition"] )
class RecognitionApplication

fun main(args: Array<String>) {
	runApplication<RecognitionApplication>(*args)
}
