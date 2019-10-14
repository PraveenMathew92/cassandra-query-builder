package com.example.cql.controller

import com.example.cql.service.QueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/")
class QueryController (val queryService: QueryService) {
    @GetMapping("/all")
    fun getAll(): Flux<String> {
        val result = queryService.getAll()
        return  result.map { it.rows() }
                .flatMapMany { it }
                .map { "${it.getString("name")}\n" }
    }

    @GetMapping("/name")
    fun getName(): Mono<String> {
        val name = "james; SELECT * FROM cql_injection.visitor"
        val result = queryService.getName(name)
        return  result.map { it.rows() }
                .flatMapMany { it }
                .next()
                .map { "${it.getString("name")}\n" }
    }
}