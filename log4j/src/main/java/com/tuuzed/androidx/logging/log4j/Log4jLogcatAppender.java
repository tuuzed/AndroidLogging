package com.tuuzed.androidx.logging.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class Log4jLogcatAppender extends AppenderSkeleton {

    private final Layout tagLayout = new PatternLayout("%c");
    private final Layout messageLayout = new PatternLayout("%m%n");

    public Log4jLogcatAppender() {
        setLayout(messageLayout);
    }

    @Override
    protected void append(LoggingEvent event) {
        switch (event.getLevel().toInt()) {
            case Level.TRACE_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.v(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.v(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
            case Level.DEBUG_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.d(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.d(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
            case Level.INFO_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.i(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.i(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
            case Level.WARN_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.w(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.w(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
            case Level.ERROR_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.e(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.e(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
            case Level.FATAL_INT:
                if (event.getThrowableInformation() == null) {
                    android.util.Log.wtf(tagLayout.format(event), getLayout().format(event));
                } else {
                    android.util.Log.wtf(tagLayout.format(event), getLayout().format(event), event.getThrowableInformation().getThrowable());
                }
                break;
        }

    }

    @Override
    public void close() {
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
