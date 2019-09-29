package com.example.controller

import com.example.service.QueryService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test

class QueryControllerTest {
    private val queryService = mock<QueryService>()
    private val queryController = QueryController(queryService)

    @Test
    fun `should call query service for select all query`() {
        queryController.getAll()

        verify(queryService, times(1)).getAll()
    }
}