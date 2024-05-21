package exercises.classes.abstr.vehicles;

public abstract class Vehicle {
    private static int maxId = 0;
    protected int id;
    protected int number_wheels;
    protected double max_speed;
    protected double position;
    protected double current_speed;

    public void setSpeed(double speed) {
        if (speed > max_speed) current_speed = max_speed;
        else if (-speed > max_speed) current_speed = -max_speed;
        else current_speed = speed;
    }

    public void drive(double minutes) {
        position += current_speed*(minutes/60);
    }

    public Vehicle() {
        maxId++;
        this.id = maxId;
        this.number_wheels = 0;
        this.max_speed = 0;
        this.position = 0;
        this.current_speed = 0;
    }

    public Vehicle(int number_wheels, double max_speed, double position, double current_speed) {
        this();
        this.number_wheels = number_wheels;
        this.max_speed = max_speed;
        this.position = position;
        this.current_speed = current_speed;
    }

    public double getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " no. " + id + ":" +
                "\n\tnumber of wheels: " + number_wheels +
                "\n\tmax_speed: " + max_speed +
                "\n\tposition: " + position +
                "\n\tcurrent speed: " + current_speed;
    }
}
