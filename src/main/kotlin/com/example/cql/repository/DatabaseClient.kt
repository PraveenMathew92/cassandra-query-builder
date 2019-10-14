package com.example.cql.repository

import com.datastax.driver.core.RegularStatement
import com.datastax.driver.core.querybuilder.Clause
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.example.cql.CassandraConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.cassandra.ReactiveResultSet
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class DatabaseClient(@Autowired
                     private val cassandraConfig: CassandraConfig) {
    private val reactiveSession = cassandraConfig.reactiveSession()

    fun selectAllQuery(): Mono<ReactiveResultSet> {
        val statement: RegularStatement = QueryBuilder.select().all().from("visitor")
        return reactiveSession.execute(statement)
    }

    fun selectName(name: String): Mono<ReactiveResultSet> {
        val statement: RegularStatement = QueryBuilder.select().from("visitor").where(QueryBuilder.eq("name", name))
        return reactiveSession.execute(statement)
    }
}
