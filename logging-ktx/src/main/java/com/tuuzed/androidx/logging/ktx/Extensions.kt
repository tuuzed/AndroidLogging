package com.tuuzed.androidx.logging.ktx

import com.tuuzed.androidx.logging.Log2

fun LOG2V(tag: String, msg: String) = Log2.v(tag, msg)
fun LOG2V(tag: String, msg: String, tr: Throwable?) = Log2.v(tag, msg, tr)

fun LOG2D(tag: String, msg: String) = Log2.d(tag, msg)
fun LOG2D(tag: String, msg: String, tr: Throwable?) = Log2.d(tag, msg, tr)

fun LOG2I(tag: String, msg: String) = Log2.i(tag, msg)
fun LOG2I(tag: String, msg: String, tr: Throwable?) = Log2.i(tag, msg, tr)

fun LOG2W(tag: String, msg: String) = Log2.w(tag, msg)
fun LOG2W(tag: String, msg: String, tr: Throwable?) = Log2.w(tag, msg, tr)

fun LOG2E(tag: String, msg: String) = Log2.e(tag, msg)
fun LOG2E(tag: String, msg: String, tr: Throwable?) = Log2.e(tag, msg, tr)

fun LOG2F(tag: String, msg: String) = Log2.wtf(tag, msg)
fun LOG2F(tag: String, msg: String, tr: Throwable?) = Log2.wtf(tag, msg, tr)