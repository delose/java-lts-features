package com.delose.java.lts.design_patterns.structural;

interface Logger {
    void log(String message);
}

class LegacyLogger {
    public void logData(String data, String timestamp) {
        System.out.println("LEGACY LOG [" + timestamp + "]: " + data);
    }
}

class LoggerAdapter implements Logger {

    private final LegacyLogger legacyLogger;

    LoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void log(String message) {
        String timestamp = new java.util.Date().toString();
        legacyLogger.logData(message, timestamp);
    }
}

public class Adapter {
    public static void main(String[] args) {
        LegacyLogger existingLogger = new LegacyLogger();

        Logger adapter = new LoggerAdapter(existingLogger);

        adapter.log("User login event occurred");
    }
}
