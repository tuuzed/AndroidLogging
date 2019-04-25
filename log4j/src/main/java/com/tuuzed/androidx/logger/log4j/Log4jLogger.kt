package com.tuuzed.androidx.logger.log4j

import android.content.Context
import android.util.Log
import com.tuuzed.androidx.logger.LogLevel
import com.tuuzed.androidx.logger.Logger
import org.apache.log4j.Level
import java.io.File

typealias Log4j = org.apache.log4j.Logger

class Log4jLogger @JvmOverloads constructor(
    cxt: Context,
    @LogLevel private val logcatLevel: Int = LogLevel.ALL,
    @LogLevel private val log4jRootLevel: Int = LogLevel.OFF,
     configurator: Log4jConfigurator = Log4jConfigurator(
        File(cxt.getExternalFilesDir("log"), "log4j.log").absolutePath
    )
) : Logger {

    private val useLogcatAppender: Boolean = configurator.useLogcatAppender

    init {
        try {
            configurator.rootLevel = when (log4jRootLevel) {
                LogLevel.ALL -> Level.ALL
                LogLevel.VERBOSE -> Level.TRACE
                LogLevel.DEBUG -> Level.DEBUG
                LogLevel.INFO -> Level.INFO
                LogLevel.WARN -> Level.WARN
                LogLevel.ERROR -> Level.ERROR
                LogLevel.FATAL -> Level.FATAL
                LogLevel.OFF -> Level.OFF
                else -> Level.OFF
            }
            configurator.configure()
            Log.e("Log4jLogger", "Log4j config finish")
        } catch (throwable: Throwable) {
            configurator.resetConfiguration = true
            Log.e("Log4jLogger", "Log4j config error, use default config. Error:$throwable")
        }
    }

    override fun v(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.VERBOSE) {
            Log4j.getLogger(tag).trace(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.VERBOSE) {
            return Log.v(tag, msg, tr)
        }
        return 0
    }

    override fun d(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.DEBUG) {
            Log4j.getLogger(tag).debug(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.DEBUG) {
            return Log.d(tag, msg, tr)
        }
        return 0
    }

    override fun i(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.INFO) {
            Log4j.getLogger(tag).info(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.INFO) {
            return Log.i(tag, msg, tr)
        }
        return 0
    }

    override fun w(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.WARN) {
            Log4j.getLogger(tag).warn(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.WARN) {
            return Log.w(tag, msg, tr)
        }
        return 0
    }

    override fun e(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.ERROR) {
            Log4j.getLogger(tag).error(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.ERROR) {
            return Log.e(tag, msg, tr)
        }
        return 0
    }

    override fun wtf(tag: String, msg: String, tr: Throwable?): Int {
        var printed = false
        if (log4jRootLevel <= LogLevel.FATAL) {
            Log4j.getLogger(tag).fatal(msg, tr)
            printed = useLogcatAppender
        }
        if (!printed && logcatLevel <= LogLevel.FATAL) {
            return Log.wtf(tag, msg, tr)
        }
        return 0
    }


}