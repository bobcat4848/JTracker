package tech.bobcat.jtracker.util;

import javafx.scene.control.Alert;

import java.awt.*;

public class NotificationHelper {

    //private static Icon icon;


    public static void showNotification(String messsage) throws AWTException {
        try {
            //Obtain only one instance of the SystemTray object
            SystemTray tray = SystemTray.getSystemTray();

            //If the icon is a file
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            //Alternative (if the icon is on the classpath):
            //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));

            TrayIcon trayIcon = new TrayIcon(image, "JTracker");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            //Set tooltip text for the tray icon
            trayIcon.setToolTip("JTracker Notification");
            tray.add(trayIcon);

            trayIcon.displayMessage("JTracker", messsage, TrayIcon.MessageType.INFO);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

    public static void showInvalidURL() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "The URL entered is not valid.");
        alert.showAndWait();
    }
    /*
    public static void showNotification(String message) {
        TrayNotification notification = new TrayNotification("JTracker", message, Notifications.INFORMATION);
        notification.setRectangleFill(Paint.valueOf("#4286f4"));
        notification.setAnimation(Animations.POPUP);
        notification.showAndDismiss(Duration.seconds(10));
    }*/
}
