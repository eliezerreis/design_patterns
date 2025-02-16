package structural;
/*
 * The Decorator Pattern that allows you to dynamically add behavrior our responsibilities to an object without
 * modifying its code.
 *
 * Why use it?
 * - When you need to add behavior to an object, but inheritance would result in an unmanageable number of subclasses.
 * - When you want to provide a flexible and reusable alternative to subclassing.
 * - When you want to add responsibilities to objects dynamically, allowing you to stack or combine behaviors.
 *
 * Pros:
 * - Flexibility
 * - Extensibility
 * - Decoupling
 * - Separation of concerns
 */

interface Coffee {
    String description();
}

class SimpleCoffee implements Coffee {
    @Override
    public String description() {
        return "Coffee";
    }
}

abstract class Decorator implements Coffee {
    protected Coffee coffee;
    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description();
    }
}


class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + ", with Milk";
    }
}

public class DecoratorApp {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description());
    }
}
