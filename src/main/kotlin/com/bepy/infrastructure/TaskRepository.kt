package com.bepy.infrastructure

import com.bepy.domain.entity.TaskEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TaskRepository : JpaRepository<TaskEntity?, Int?>