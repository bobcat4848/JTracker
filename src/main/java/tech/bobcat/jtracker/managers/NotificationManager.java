package tech.bobcat.jtracker.managers;

import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;

import java.awt.*;

public class NotificationManager {

    private SystemTray tray;
    private Image image;
    private TrayIcon trayIcon;

    public NotificationManager() {
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();
            image = Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("icon.png"));
            trayIcon = new TrayIcon(image, "JTracker");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("JTracker Notification");

            try {
                tray.add(trayIcon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void showNotification(String messsage) {
        if (tray != null) {
            trayIcon.displayMessage("JTracker", messsage, TrayIcon.MessageType.INFO);
        } else {
            showNonSupportedOSNotification(messsage);
        }
    }

    private void showNonSupportedOSNotification(String message) {
        TrayNotification trayNotification = new TrayNotification("JTracker", message, Notifications.NOTICE);
        trayNotification.showAndWait();
    }

    public void close() {
        tray = null;
    }
}
