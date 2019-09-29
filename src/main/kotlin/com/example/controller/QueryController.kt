package com.example.controller

import com.example.service.QueryService
import org.springframework.stereotype.Controller

@Controller
class QueryController (val queryService: QueryService) {
    fun getAll() {
        queryService.getAll()
    }
}