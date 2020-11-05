package com.bepy.entrypoint

import com.bepy.domain.service.GreetingService
import helloworld.*
import javax.inject.Singleton

@Singleton
@Suppress("unused")
class GreetingEndpoint(private val greetingService: GreetingService) : GreeterGrpcKt.GreeterCoroutineImplBase() {

    override suspend fun sayHello(request: HelloRequest): HelloReply {
        val message = this.greetingService.sayHello(request)
        return HelloReply.newBuilder().setMessage(message).build()
    }
}