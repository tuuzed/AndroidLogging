package com.tuuzed.androidx.logger.log4j

import org.apache.log4j.PatternLayout
import org.apache.log4j.RollingFileAppender

class FileAppenderImpl @JvmOverloads constructor(
    filename: String,
    pattern: String = "%-d{yyyy-MM-dd HH:mm:ss.SSS} [%5p] [%t] [%c]: %m %n",
    maxBackupSize: Int = 1,
    maxFileSize: Long = 1024 * 1024 * 1,
    immediateFlush: Boolean = true
) : RollingFileAppender(PatternLayout(pattern), filename) {
    init {
        this.maxBackupIndex = maxBackupSize
        this.maximumFileSize = maxFileSize
        this.immediateFlush = immediateFlush
    }
}