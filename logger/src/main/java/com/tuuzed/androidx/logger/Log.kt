package com.tuuzed.androidx.logger

object Log {

    private var impl: Logger = DefaultLogger(LogLevel.ALL)

    @JvmStatic
    fun setImpl(impl: Logger) {
        this.impl = impl
    }

    @JvmStatic
    @JvmOverloads
    fun v(tag: String, msg: String, tr: Throwable? = null) = impl.v(tag, msg, tr)

    @JvmStatic
    @JvmOverloads
    fun d(tag: String, msg: String, tr: Throwable? = null) = impl.d(tag, msg, tr)

    @JvmStatic
    @JvmOverloads
    fun i(tag: String, msg: String, tr: Throwable? = null) = impl.i(tag, msg, tr)

    @JvmStatic
    @JvmOverloads
    fun w(tag: String, msg: String = "", tr: Throwable? = null) = impl.w(tag, msg, tr)

    @JvmStatic
    @JvmOverloads
    fun e(tag: String, msg: String, tr: Throwable? = null) = impl.e(tag, msg, tr)

    @JvmStatic
    @JvmOverloads
    fun wtf(tag: String, msg: String, tr: Throwable? = null) = impl.wtf(tag, msg, tr)

}



