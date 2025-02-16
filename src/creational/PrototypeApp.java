package creational;
/*
 * Prototype is a creational pattern that that allows create new object by copying existing objects
 * rather than create them from scratch.
 *
 * This implementation is shallow copy. We also have Deep copy to also clone the relationship.
 */

interface Prototype {
    Prototype clone();
}

/*
 * Shallow copy
 */

class Car implements Prototype {

    String color;
    String brand;
    String year;

    @Override
    public Car clone() {
        Car clone = new Car();
        clone.color = color;
        clone.brand = brand;
        clone.year = year;

        return clone;
    }

    @Override
    public String toString() {
        return "Car{" +
            "brand='" + brand + '\'' +
            ", color='" + color + '\'' +
            ", year='" + year + '\'' +
            '}';
    }
}

public class PrototypeApp {
    public static void main(String[] args) {
        Car car = new Car();
        car.color = "red";
        car.brand = "BMW";
        car.year = "2020";
        Prototype carClone = car.clone();
        System.out.println(carClone);
    }
}