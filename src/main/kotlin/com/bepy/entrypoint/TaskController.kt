package com.bepy.entrypoint

import com.bepy.domain.service.TaskService
import com.bepy.domain.model.Task
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.ArrayList
import javax.inject.Inject

@Controller("/tasks")
class TaskController(@Inject val service: TaskService) {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun getTasks(): ArrayList<Task> {
        return this.service.getTasks()
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun createTaks(request: Task): HttpStatus {
        this.service.createTask(task = request)
        return HttpStatus.CREATED
    }

    @Get("/{id}")
    fun getTask(id: Int): Task {
        return this.service.getTask(id)
    }

    @Patch("/{id}/close")
    fun closeTask(id: Int): HttpStatus {
        this.service.toCloseTask(id)
        return HttpStatus.NO_CONTENT
    }

    @Patch("/{id}/wait")
    fun waitTask(id: Int): HttpStatus {
        this.service.toWaitTask(id)
        return HttpStatus.NO_CONTENT
    }

    @Delete("/{id}")
    fun deleteTask(id: Int): HttpStatus {
        this.service.deleteTask(id)
        return HttpStatus.NO_CONTENT
    }

}