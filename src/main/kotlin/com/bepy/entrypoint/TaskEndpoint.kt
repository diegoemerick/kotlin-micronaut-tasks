package com.bepy.entrypoint

import com.bepy.domain.model.Task
import com.bepy.domain.service.TaskService
import helloworld.*
import javax.inject.Singleton

@Singleton
@Suppress("unused")
class TaskEndpoint(private val taskService: TaskService) : TaskServiceGrpcKt.TaskServiceCoroutineImplBase() {

    override suspend fun sendTask(request: TaskRequest): ResponseSuccess {
        val task = Task(id = 0, title = request.title, status = "")
        this.taskService.createTask(task = task)

        return ResponseSuccess.newBuilder().build()
    }

    override suspend fun getTask(request: TaskGet): TaskResponse {
        val task = this.taskService.getTask(request.id)

        return TaskResponse.newBuilder()
                .setTitle(task.title)
                .setId(task.id!!)
                .setStatus(task.status)
                .build()
    }

    override suspend fun getTasks(request: TaskGet): TasksResponse {
        return this.taskService.getTasksGrpc()
    }
}