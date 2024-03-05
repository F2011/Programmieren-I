package exercises.classes.vehicles;

public class Ambulance extends Car {
    private boolean emergencyLightOn;
    public Ambulance(double position, double current_speed) {
        super(position, current_speed);
        emergencyLightOn = false;
    }

    public void turnOnEmergencyLight() {
        emergencyLightOn = true;
    }

    public void turnOffEmergencyLight() {
        emergencyLightOn = false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Emergency lights: " + (emergencyLightOn ? "on" : "off");
    }
}
