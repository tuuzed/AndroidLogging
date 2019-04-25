package com.tuuzed.androidx.logger

import androidx.annotation.IntDef

@IntDef(
    flag = true,
    value = [
        LogLevel.ALL,
        LogLevel.VERBOSE,
        LogLevel.DEBUG,
        LogLevel.INFO,
        LogLevel.WARN,
        LogLevel.ERROR,
        LogLevel.FATAL,
        LogLevel.OFF
    ]
)
@Retention(AnnotationRetention.SOURCE)
annotation class LogLevel {
    companion object {
        const val ALL = Int.MIN_VALUE
        const val VERBOSE = 1
        const val DEBUG = 2
        const val INFO = 3
        const val WARN = 4
        const val ERROR = 5
        const val FATAL = 6
        const val OFF = Int.MAX_VALUE
    }
}