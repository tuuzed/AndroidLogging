package com.tuuzed.androidx.logging.ktx

import com.tuuzed.androidx.logging.Logger

fun LOGV(tag: String, msg: String) = Logger.v(tag, msg)
fun LOGV(tag: String, msg: String, tr: Throwable?) = Logger.v(tag, msg, tr)
fun LOGD(tag: String, msg: String) = Logger.d(tag, msg)
fun LOGD(tag: String, msg: String, tr: Throwable?) = Logger.d(tag, msg, tr)
fun LOGI(tag: String, msg: String) = Logger.i(tag, msg)
fun LOGI(tag: String, msg: String, tr: Throwable?) = Logger.i(tag, msg, tr)
fun LOGW(tag: String, msg: String) = Logger.w(tag, msg)
fun LOGW(tag: String, msg: String, tr: Throwable?) = Logger.w(tag, msg, tr)
fun LOGE(tag: String, msg: String) = Logger.e(tag, msg)
fun LOGE(tag: String, msg: String, tr: Throwable?) = Logger.e(tag, msg, tr)
fun LOGF(tag: String, msg: String) = Logger.wtf(tag, msg)
fun LOGF(tag: String, msg: String, tr: Throwable?) = Logger.wtf(tag, msg, tr)


@Deprecated(message = "", replaceWith = ReplaceWith("LOGV"))
fun LOG2V(tag: String, msg: String) = Logger.v(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGV"))
fun LOG2V(tag: String, msg: String, tr: Throwable?) = Logger.v(tag, msg, tr)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGD"))
fun LOG2D(tag: String, msg: String) = Logger.d(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGD"))
fun LOG2D(tag: String, msg: String, tr: Throwable?) = Logger.d(tag, msg, tr)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGI"))
fun LOG2I(tag: String, msg: String) = Logger.i(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGI"))
fun LOG2I(tag: String, msg: String, tr: Throwable?) = Logger.i(tag, msg, tr)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGW"))
fun LOG2W(tag: String, msg: String) = Logger.w(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGW"))
fun LOG2W(tag: String, msg: String, tr: Throwable?) = Logger.w(tag, msg, tr)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGE"))
fun LOG2E(tag: String, msg: String) = Logger.e(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGE"))
fun LOG2E(tag: String, msg: String, tr: Throwable?) = Logger.e(tag, msg, tr)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGF"))
fun LOG2F(tag: String, msg: String) = Logger.wtf(tag, msg)

@Deprecated(message = "", replaceWith = ReplaceWith("LOGF"))
fun LOG2F(tag: String, msg: String, tr: Throwable?) = Logger.wtf(tag, msg, tr)