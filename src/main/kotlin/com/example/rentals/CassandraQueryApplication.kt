package com.example.rentals

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CassandraQueryApplication

fun main(args: Array<String>) {
    runApplication<CassandraQueryApplication>(*args)
}
