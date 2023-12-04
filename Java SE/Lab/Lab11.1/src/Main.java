import models.Car;
import models.VinFast;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(6, "Base Car");
        System.out.println(car.accelerate());
        System.out.println(car.brake());
        System.out.println(car.startEngine());

        VinFast vinFast = new VinFast(8, "VF5 Luxury");
        System.out.println(vinFast.accelerate());
        System.out.println(vinFast.brake());
        System.out.println(vinFast.startEngine());
    }
}