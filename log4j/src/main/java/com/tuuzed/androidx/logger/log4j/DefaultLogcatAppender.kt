package com.tuuzed.androidx.logger.log4j

import android.util.Log
import org.apache.log4j.*
import org.apache.log4j.spi.LoggingEvent

class LogcatAppenderImpl @JvmOverloads constructor(
    private val tagLayout: Layout = PatternLayout("%c"),
    messageLayout: Layout = PatternLayout("%m%n")
) : AppenderSkeleton() {

    init {
        this.setLayout(messageLayout)
    }

    override fun append(le: LoggingEvent) {
        when (le.getLevel()) {
            Level.TRACE -> if (le.throwableInformation != null) {
                Log.v(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.v(this.tagLayout.format(le), this.getLayout().format(le))
            }
            Level.DEBUG -> if (le.throwableInformation != null) {
                Log.d(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.d(this.tagLayout.format(le), this.getLayout().format(le))
            }
            Level.INFO -> if (le.throwableInformation != null) {
                Log.i(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.i(this.tagLayout.format(le), this.getLayout().format(le))
            }
            Level.WARN -> if (le.throwableInformation != null) {
                Log.w(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.w(this.tagLayout.format(le), this.getLayout().format(le))
            }
            Level.ERROR -> if (le.throwableInformation != null) {
                Log.e(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.e(this.tagLayout.format(le), this.getLayout().format(le))
            }
            Level.FATAL -> if (le.throwableInformation != null) {
                Log.wtf(
                    this.tagLayout.format(le),
                    this.getLayout().format(le),
                    le.throwableInformation.throwable
                )
            } else {
                Log.wtf(this.tagLayout.format(le), this.getLayout().format(le))
            }
        }

    }

    override fun close() {}
    override fun requiresLayout(): Boolean = true

}