package com.tuuzed.androidx.logging.ktx

import com.tuuzed.androidx.logging.Logger

fun LOG2V(tag: String, msg: String) = Logger.v(tag, msg)
fun LOG2V(tag: String, msg: String, tr: Throwable?) = Logger.v(tag, msg, tr)

fun LOG2D(tag: String, msg: String) = Logger.d(tag, msg)
fun LOG2D(tag: String, msg: String, tr: Throwable?) = Logger.d(tag, msg, tr)

fun LOG2I(tag: String, msg: String) = Logger.i(tag, msg)
fun LOG2I(tag: String, msg: String, tr: Throwable?) = Logger.i(tag, msg, tr)

fun LOG2W(tag: String, msg: String) = Logger.w(tag, msg)
fun LOG2W(tag: String, msg: String, tr: Throwable?) = Logger.w(tag, msg, tr)

fun LOG2E(tag: String, msg: String) = Logger.e(tag, msg)
fun LOG2E(tag: String, msg: String, tr: Throwable?) = Logger.e(tag, msg, tr)

fun LOG2F(tag: String, msg: String) = Logger.wtf(tag, msg)
fun LOG2F(tag: String, msg: String, tr: Throwable?) = Logger.wtf(tag, msg, tr)