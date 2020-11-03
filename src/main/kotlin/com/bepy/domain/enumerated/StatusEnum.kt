package com.bepy.domain.enumerated

enum class StatusEnum(val value: Int, val description: String?) {
    OPEN(0, "OPEN"),
    WAIT(1, "WAIT"),
    CLOSED(2, "CLOSED")
}