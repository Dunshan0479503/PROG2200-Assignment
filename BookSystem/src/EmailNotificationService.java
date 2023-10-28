class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Code to send an email notification
        System.out.println("Email notification: " + message);
    }
}