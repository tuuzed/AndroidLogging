package com.tuuzed.androidx.logger

import android.util.Log

class DefaultLogger @JvmOverloads constructor(
    @LogLevel val level: Int = LogLevel.ALL
) : Logger {

    override fun v(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.v(tag, msg, tr)
        } else {
            0
        }
    }

    override fun d(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.d(tag, msg, tr)
        } else {
            0
        }
    }

    override fun i(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.i(tag, msg, tr)
        } else {
            0
        }
    }

    override fun w(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.w(tag, msg, tr)
        } else {
            0
        }
    }

    override fun e(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.e(tag, msg, tr)
        } else {
            0
        }
    }

    override fun wtf(tag: String, msg: String, tr: Throwable?): Int {
        return if (level <= LogLevel.VERBOSE) {
            Log.wtf(tag, msg, tr)
        } else {
            0
        }
    }


}