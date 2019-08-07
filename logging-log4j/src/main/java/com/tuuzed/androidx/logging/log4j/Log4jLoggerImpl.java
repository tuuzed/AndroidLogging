package com.tuuzed.androidx.logging.log4j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tuuzed.androidx.logging.DefaultLoggerImpl;
import com.tuuzed.androidx.logging.Logger;
import org.apache.log4j.Appender;

public class Log4jLoggerImpl implements Logger.Interface {

    private final int level;

    public Log4jLoggerImpl(
            @Logger.Level int level,
            @NonNull Appender logcatAppender,
            @Nullable Appender fileAppender
    ) {
        this.level = level;
        final org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
        rootLogger.removeAllAppenders();
        rootLogger.addAppender(logcatAppender);
        if (fileAppender != null) {
            rootLogger.addAppender(fileAppender);
        }
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.VERBOSE) org.apache.log4j.Logger.getLogger(tag).trace(msg);
        return 0;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.VERBOSE) org.apache.log4j.Logger.getLogger(tag).trace(msg, tr);
        return 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.DEBUG) org.apache.log4j.Logger.getLogger(tag).debug(msg);
        return 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.DEBUG) org.apache.log4j.Logger.getLogger(tag).debug(msg, tr);
        return 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.INFO) org.apache.log4j.Logger.getLogger(tag).info(msg);
        return 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.INFO) org.apache.log4j.Logger.getLogger(tag).info(msg, tr);
        return 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.WARN) org.apache.log4j.Logger.getLogger(tag).warn(msg);
        return 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.WARN) org.apache.log4j.Logger.getLogger(tag).warn(msg, tr);
        return 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.ERROR) org.apache.log4j.Logger.getLogger(tag).error(msg);
        return 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.ERROR) org.apache.log4j.Logger.getLogger(tag).error(msg, tr);
        return 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg) {
        if (level <= Logger.FATAL) org.apache.log4j.Logger.getLogger(tag).fatal(msg);
        return 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg, Throwable tr) {
        if (level <= Logger.FATAL) org.apache.log4j.Logger.getLogger(tag).fatal(msg, tr);
        return 0;
    }
}
