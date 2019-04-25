package com.tuuzed.androidx.logger

interface Logger {
    fun v(tag: String, msg: String, tr: Throwable?): Int
    fun d(tag: String, msg: String, tr: Throwable?): Int
    fun i(tag: String, msg: String, tr: Throwable?): Int
    fun w(tag: String, msg: String, tr: Throwable?): Int
    fun e(tag: String, msg: String, tr: Throwable?): Int
    fun wtf(tag: String, msg: String, tr: Throwable?): Int
}