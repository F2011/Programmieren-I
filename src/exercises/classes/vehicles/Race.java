package exercises.classes.vehicles;

public class Race {
    public static void main(String[] args) {
        var bike = new Bicycle(0, 20.0);
        var car = new Car(0, 150);
        var racingCar = new RacingCar(0, 200);
        var ambulance = new Ambulance(0, 80);

        bike.drive(4 * 60);

        bike.drive(60);
        car.drive(60);
        racingCar.drive(60);
        ambulance.drive(60);

        System.out.println("Bike: " + bike.getPosition());
        System.out.println("Car: " + car.getPosition());
        System.out.println("RacingCar: " + racingCar.getPosition());
        System.out.println("Ambulance: " + ambulance.getPosition());
    }

}
