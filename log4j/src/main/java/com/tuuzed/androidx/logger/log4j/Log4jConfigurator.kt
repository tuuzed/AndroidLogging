package com.tuuzed.androidx.logger.log4j

import com.tuuzed.androidx.logger.LogLevel
import org.apache.log4j.*
import org.apache.log4j.helpers.LogLog
import java.io.IOException

class Log4jConfigurator @JvmOverloads constructor(
    var filename: String,
    var rootLevel: Level = Level.DEBUG,
    var filePattern: String = "%-d{yyyy-MM-dd HH:mm:ss.SSS} [%5p] [%t] [%c]: %m %n",
    var logCatPattern: String = "%m%n",
    var maxBackupSize: Int = 10,
    var maxFileSize: Long = 1024 * 1024 * 1,
    var immediateFlush: Boolean = true,
    var useLogcatAppender: Boolean = true,
    var useFileAppender: Boolean = true,
    var resetConfiguration: Boolean = false,
    var internalDebugging: Boolean = false
) {

    fun configure() {
        val root = Logger.getRootLogger()
        if (this.resetConfiguration) {
            LogManager.getLoggerRepository().resetConfiguration()
        }
        LogLog.setInternalDebugging(this.internalDebugging)
        if (this.useFileAppender) {
            this.configureFileAppender()
        }
        if (this.useLogcatAppender) {
            this.configureLogcatAppender()
        }
        root.level = this.rootLevel
    }

    fun setLevel(loggerName: String, @LogLevel level: Int) {
        Logger.getLogger(loggerName).level = when (level) {
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
    }

    private fun configureFileAppender() {
        val root = Logger.getRootLogger()
        val fileLayout = PatternLayout(this.filePattern)
        val rollingFileAppender: RollingFileAppender
        try {
            rollingFileAppender = RollingFileAppender(fileLayout, this.filename)
        } catch (e: IOException) {
            throw RuntimeException("Exception configuring log system", e)
        }
        rollingFileAppender.maxBackupIndex = this.maxBackupSize
        rollingFileAppender.maximumFileSize = this.maxFileSize
        rollingFileAppender.immediateFlush = this.immediateFlush
        root.addAppender(rollingFileAppender)
    }

    private fun configureLogcatAppender() {
        val root = Logger.getRootLogger()
        val logcatLayout = PatternLayout(this.logCatPattern)
        val logcatAppender = Log4jLogcatAppender(logcatLayout)
        root.addAppender(logcatAppender)
    }
}