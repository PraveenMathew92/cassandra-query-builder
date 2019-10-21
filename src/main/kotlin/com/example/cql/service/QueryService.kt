package com.example.cql.service

import com.example.cql.repository.DatabaseClient
import org.springframework.stereotype.Service

@Service
class QueryService (val databaseClient: DatabaseClient) {
    fun getAll() = databaseClient.findAll()

    fun getName(name: String) = databaseClient.findByName(name)
}
