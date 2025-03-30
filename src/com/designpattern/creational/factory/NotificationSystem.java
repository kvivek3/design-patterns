package com.designpattern.creational.factory;

interface Notification {
    public void send(String message);
}

class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}
class NotificationFactory {

    public Notification createNotification(String notificationType) {
        if(notificationType == null)
            return null;
        else if(notificationType.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        else if(notificationType.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        else if(notificationType.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }
}
public class NotificationSystem {
    public static void main(String[] args) {

          NotificationFactory factory = new NotificationFactory();

          Notification email = factory.createNotification("EMAIL");
          email.send("Hi, Welcome to service");

          Notification sms = factory.createNotification("SMS");
          sms.send("Your OTP to login is 123456");

          Notification push = factory.createNotification("PUSH");
          push.send("New Message");

    }
}
