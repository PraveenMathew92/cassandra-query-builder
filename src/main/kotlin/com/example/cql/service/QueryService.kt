package com.example.cql.service

import com.example.cql.repository.DatabaseClient
import org.springframework.stereotype.Service

@Service
class QueryService (val databaseClient: DatabaseClient) {
    fun getAll() = databaseClient.selectAllQuery()

    fun getName(name: String) = databaseClient.selectName(name)
}
