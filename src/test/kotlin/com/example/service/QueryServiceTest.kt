package com.example.service

import com.example.cql.service.QueryService
import com.example.cql.repository.DatabaseClient
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class QueryServiceTest{
    private val databaseClient = mock<DatabaseClient>()
    private val queryService = QueryService(databaseClient)

    @Test
    fun `should call select all query form database`() {
        queryService.getAll()

        verify(databaseClient, times(1)).selectAllQuery()
    }
}