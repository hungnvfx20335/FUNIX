package models;

public class VinFast extends Car {

    public VinFast(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "VinFast -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "VinFast -> accelerate()";
    }

    @Override
    public String brake() {
        return "VinFast -> brake()";
    }
}
