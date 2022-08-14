package com.example.loggingconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class LoggingConsumerApplication

fun main(args: Array<String>) {
    runApplication<LoggingConsumerApplication>(*args)
}

@Configuration
class LogConsumer {

    @Bean
    fun log(): (Person) -> Unit = {
        println("Received: $it")

    }

    @NoArg
    data class Person(val name: String) {
        override fun toString(): String = name
    }
}

annotation class NoArg