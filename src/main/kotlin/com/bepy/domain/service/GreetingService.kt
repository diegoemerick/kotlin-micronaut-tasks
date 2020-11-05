package com.bepy.domain.service

import helloworld.HelloRequest
import javax.inject.Singleton

@Singleton
class GreetingService {

    fun sayHello(value: HelloRequest?): String? {
        if (value != null) {
            return "${value.name}, World"
        }
        return null
    }

}