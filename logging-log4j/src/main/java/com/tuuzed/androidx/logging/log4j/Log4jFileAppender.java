package com.tuuzed.androidx.logging.log4j;

import androidx.annotation.NonNull;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;

public class Log4jFileAppender extends RollingFileAppender {

    private static final Layout defaultLayout = new PatternLayout(
            "%-d{yyyy-MM-dd HH:mm:ss.SSS} [%5p] [%t] [%c]: %m %n"
    );

    public Log4jFileAppender(@NonNull String filename, boolean append) throws IOException {
        this(defaultLayout, filename, append);
    }

    public Log4jFileAppender(@NonNull Layout layout, @NonNull String filename, boolean append) throws IOException {
        super(layout, filename, append);
        setImmediateFlush(true);
        setMaximumFileSize(1024 * 1024); // 1MB
        setMaxBackupIndex(1);
    }

    @NonNull
    public Log4jFileAppender immediateFlush(boolean value) {
        super.setImmediateFlush(value);
        return this;
    }

    @NonNull
    public Log4jFileAppender maxBackupCount(int value) {
        super.setMaxBackupIndex(value);
        return this;
    }

    @NonNull
    public Log4jFileAppender maximumFileSize(long value) {
        super.setMaximumFileSize(maxFileSize);
        return this;
    }

    @Override
    public void append(LoggingEvent event) {
        super.append(event);
    }
}
