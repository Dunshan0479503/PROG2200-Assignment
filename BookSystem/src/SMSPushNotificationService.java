class SMSPushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Code to send an SMS notification
        System.out.println("SMS notification: " + message);
    }
}