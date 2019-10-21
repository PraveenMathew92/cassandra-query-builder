package com.example.cql.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey

data class Visitor(@PrimaryKey val name: String, val age: Int)