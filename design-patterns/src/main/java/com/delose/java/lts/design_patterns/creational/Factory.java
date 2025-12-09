package com.delose.java.lts.design_patterns.creational;

interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {

    }
}

class EmailNotificaiton implements Notification {

    @Override
    public void notifyUser() {

    }
}

public class Factory {

    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return  null;
        }
        switch (channel.toLowerCase()) {
            case "sms":
                return new SMSNotification();
            case "email":
                return new EmailNotificaiton();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

}
