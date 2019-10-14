package com.example.cql

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories
class CassandraConfig : AbstractReactiveCassandraConfiguration() {
    override fun getKeyspaceName() = "cql_injection"

    override fun getSchemaAction() = SchemaAction.CREATE_IF_NOT_EXISTS

    override fun cluster(): CassandraClusterFactoryBean {
        val cluster = super.cluster()
        cluster.setContactPoints("localhost")
        cluster.setPort(9042)
        cluster.setJmxReportingEnabled(false)
        return cluster
    }
}