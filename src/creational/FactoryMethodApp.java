package creational;

/*
 * Factory Method define a interface to create objects centralizing the object creation.
 * If something change on the object intialization we have to do changes in only one place.
 */


interface Animal {
    void makeNoise();
}


class Dog implements Animal {

    public void makeNoise() {
        System.out.println("Wolf");
    }
}


class Cat implements Animal {
     public void makeNoise() {
        System.out.println("Meow");
    }
}

interface AnimalFactory {
    Animal create();
}


class CatFactory implements AnimalFactory {
    @Override
    public Animal create() {
        return new Cat();
    }
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal create() {
        return new Dog();
    }
}

// Static Factory Method
class Factory {
    public static Animal createAnimal(String type) {
        if(type.equalsIgnoreCase("cat")) {
            return new Cat();
        } else {
            return new Dog();
        }
    }
}

class ReflectionFactory {
    public static Animal createAnimal(Class<? extends Animal> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class FactoryMethodApp {
    public static void main (String[] args) {
        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.create();
        cat.makeNoise();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.create();
        dog.makeNoise();

        Animal dog1 = Factory.createAnimal("dog");
        dog1.makeNoise();

        Animal dog2 = ReflectionFactory.createAnimal(Dog.class);
        dog2.makeNoise();
    }
}