package com.tuuzed.androidx.logging.log4j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tuuzed.androidx.logging.DefaultLog2Impl;
import com.tuuzed.androidx.logging.Log2;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

public class Log4jLog2Impl implements Log2.Interface {

    private final int level;

    public Log4jLog2Impl(@Log2.Level int level,
                         @NonNull Appender logcatAppender,
                         @Nullable Appender fileAppender) {
        this.level = level;
        final Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(logcatAppender);
        if (fileAppender != null) {
            rootLogger.addAppender(fileAppender);
        }
        new DefaultLog2Impl();
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.VERBOSE) Logger.getLogger(tag).trace(msg);
        return 0;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.VERBOSE) Logger.getLogger(tag).trace(msg, tr);
        return 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.DEBUG) Logger.getLogger(tag).debug(msg);
        return 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.DEBUG) Logger.getLogger(tag).debug(msg, tr);
        return 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.INFO) Logger.getLogger(tag).info(msg);
        return 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.INFO) Logger.getLogger(tag).info(msg, tr);
        return 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.WARN) Logger.getLogger(tag).warn(msg);
        return 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.WARN) Logger.getLogger(tag).warn(msg, tr);
        return 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.ERROR) Logger.getLogger(tag).error(msg);
        return 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.ERROR) Logger.getLogger(tag).error(msg, tr);
        return 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg) {
        if (level <= Log2.FATAL) Logger.getLogger(tag).fatal(msg);
        return 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Log2.FATAL) Logger.getLogger(tag).fatal(msg, tr);
        return 0;
    }
}
