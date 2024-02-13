package exercises.classes;

public class Radio {
    private boolean on;
    private int volume;
    private double frequency;

    public Radio() {
        this.on = false;
        this.volume = 3;
        this.frequency = 95.0;
    }

    public Radio(boolean on, int volume, double frequency) {
        setOn(on);
        setVolume(volume);
        setFrequency(frequency);
    }

    private void setOn(boolean on) {
        this.on = on;
    }

    private void setVolume(int volume) {
        if (volume > 10) this.volume = 10;
        else if (volume < 0) this.volume = 0;
        else this.volume = volume;
    }

    public void setFrequency(double frequency) {
        if (frequency < 110.0 && frequency > 85.0) this.frequency = frequency;
        else this.frequency = 99.9;
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    public void incVolume() {
        if (on) setVolume(volume + 1);
    }

    public void decVolume() {
        if (on) setVolume(volume - 1);
    }

    @Override
    public String toString() {
        if (!on) {
            return "Radio aus";
        } else {
            return String.format("Radio an: Freq=%.1f, Laut=%d", frequency, volume);
        }
    }
}
