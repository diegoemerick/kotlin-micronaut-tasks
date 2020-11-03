package com.bepy.domain.service

import com.bepy.domain.entity.TaskEntity
import com.bepy.domain.enumerated.StatusEnum
import com.bepy.domain.exception.TaskNotFoundException
import com.bepy.domain.model.Task
import com.bepy.infrastructure.TaskRepository
import java.util.*
import java.util.stream.Collectors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskService(@Inject val repository: TaskRepository) {

    fun createTask(task: Task) {
        val entity = TaskEntity()
        entity.title = task.title
        entity.status = StatusEnum.OPEN.value

        this.repository.save(entity)
    }

    fun getTask(id: Int): Task {
        val entity: Optional<TaskEntity?> = this.repository.findById(id)

        if (entity.isPresent) {
            return Task(
                    id = entity.get().id,
                    title = entity.get().title,
                    status = StatusEnum.values()[entity.get().status].description)
        }

        throw TaskNotFoundException("Task not found")
    }

    fun getTasks(): ArrayList<Task> {
        val tasks: MutableList<TaskEntity?> = this.repository.findAll()
        val list: ArrayList<Task> = ArrayList()

        tasks.stream()
                .map { task ->
                    list.add(Task(id = task?.id, title = task?.title!!, status = StatusEnum.values()[task.status].description))
                }.collect(Collectors.toList())

        return list
    }

    fun toWaitTask(id: Int) {
        val task: Optional<TaskEntity?> = this.repository.findById(id)

        if (task.isPresent) {
            task.get().status = StatusEnum.WAIT.value
            this.repository.update(task.get())

            return
        }

        throw TaskNotFoundException("Task not found")
    }

    fun toCloseTask(id: Int) {
        val task: Optional<TaskEntity?> = this.repository.findById(id)

        if (task.isPresent) {
            task.get().status = StatusEnum.CLOSED.value
            this.repository.update(task.get())

            return
        }

        throw TaskNotFoundException("Task not found")
    }

    fun deleteTask(id: Int) {
        val task: Optional<TaskEntity?> = this.repository.findById(id)

        if (task.isPresent) {
            this.repository.delete(task.get())
            return
        }

        throw TaskNotFoundException("Task not found")
    }

}
