package tech.bobcat.jtracker.data;

public class Options {

    private int timeFrequency;
    private boolean playNotificationSound;

    public Options() {
        this(300, true);
    }

    public Options(int timeFrequency, boolean playNotificationSound) {
        this.timeFrequency = timeFrequency;
        this.playNotificationSound = playNotificationSound;
    }

    public int getTimeFrequency() {
        return timeFrequency;
    }

    public boolean playNotificationSound() {
        return playNotificationSound;
    }

    public void setTimeFrequency(int timeFrequency) {
        this.timeFrequency = timeFrequency;
    }

    public void setPlayNotificationSound(boolean playNotificationSound) {
        this.playNotificationSound = playNotificationSound;
    }
}
