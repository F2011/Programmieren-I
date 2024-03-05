package exercises.classes.vehicles;

public class Car extends Vehicle {
    public Car(double position, double current_speed) {
        super(4, 140, position, current_speed);
    }

    protected Car(double max_speed, double position, double current_speed) {
        super(4, max_speed, position, current_speed);
    }
}
