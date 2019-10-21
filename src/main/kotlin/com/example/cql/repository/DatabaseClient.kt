package com.example.cql.repository

import com.example.cql.model.Visitor
import org.springframework.data.cassandra.repository.Query
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface DatabaseClient : ReactiveCassandraRepository<Visitor, String>{
    @Query("SELECT * FROM visitor WHERE name = ?0")
    fun findByName(name: String): Flux<Visitor>
}