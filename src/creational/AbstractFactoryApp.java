package creational;
/*
 * Define the interface to create similar objects (in this case chairs).
 * Why?
 * - When you need to create related products
 *
 * pros:
 * - Help decoupling the client from teh concrete classes
 * - Flexlibity, consistency, maintenability .
 * - THe product creation is extrated transfered to the abstract class (SRP)
 * - Partial Open/Close Principel
 */


import java.util.HashMap;
import java.util.Map;

//Step 1: Move all common products to a common interface
interface Chair {
    int getLegsNumber();

    int getWidth();
}

class ModernChair implements Chair {
    private int legsNumber = 4;
    private int width = 50;

    @Override
    public int getLegsNumber() {
        return this.legsNumber;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

}


class VintageChair implements Chair {
    private int legsNumber = 3;
    private int width = 25;

    @Override
    public int getLegsNumber() {
        return this.legsNumber;
    }

    @Override
    public int getWidth() {
        return this.width;
    }
}


//Step 2: Create a Abstract Factory with all creation methods
interface ChairFactory {
    Chair createChair();
}


//Step 3: Create the concrete class
class ModernChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}


class VintageChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new VintageChair();
    }
}

//Alternative
class ChairFactoryRegistry {

    Map<String, ChairFactory> registry = new HashMap<>();

    public void registry(String type, ChairFactory factory) {
        registry.put(type, factory);
    }

    public Chair createChair(String type) {
        ChairFactory factory = registry.get(type);

        if (factory == null) {
            throw new IllegalArgumentException("Unknown chair type: " + type);
        }

        return factory.createChair();
    }
}

// Step 4: Use it
public class AbstractFactoryApp {
    public static void main(String[] args) {
        //direct instantiation
        Chair c1 = new ModernChair();
        Chair c2 = new VintageChair();

        // abstract factory
        ChairFactory modernFactory = new ModernChairFactory();
        ChairFactory vintageFactory = new VintageChairFactory();

        Chair modern = modernFactory.createChair();
        Chair vintage = vintageFactory.createChair();

        //Using a static factory
        ChairFactoryRegistry registry = new ChairFactoryRegistry();
        registry.registry("modern", new ModernChairFactory());
        registry.registry("vintage", new VintageChairFactory());
        Chair c3 = registry.createChair("modern");


    }
}




