package com.tuuzed.androidx.logger

fun LOGV(tag: String, msg: String) = Log.v(tag, msg)
fun LOGV(tag: String, msg: String, tr: Throwable?) = Log.v(tag, msg, tr)

fun LOGD(tag: String, msg: String) = Log.d(tag, msg)
fun LOGD(tag: String, msg: String, tr: Throwable?) = Log.d(tag, msg, tr)

fun LOGI(tag: String, msg: String) = Log.i(tag, msg)
fun LOGI(tag: String, msg: String, tr: Throwable?) = Log.i(tag, msg, tr)

fun LOGW(tag: String, msg: String) = Log.w(tag, msg)
fun LOGW(tag: String, msg: String, tr: Throwable?) = Log.w(tag, msg, tr)
fun LOGW(tag: String, tr: Throwable?) = Log.w(tag, tr = tr)

fun LOGE(tag: String, msg: String) = Log.e(tag, msg)
fun LOGE(tag: String, msg: String, tr: Throwable?) = Log.e(tag, msg, tr)

fun LOGF(tag: String, msg: String) = Log.wtf(tag, msg)
fun LOGF(tag: String, msg: String, tr: Throwable?) = Log.wtf(tag, msg, tr)