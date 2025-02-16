package creational;

/*
 * Provide a new way to construct a complex object step by step.
 * It's useful when the object being created has lots of parameters.
 * - when an object requires multiples steps for construction
 * - when the object has multiple optional
 */
class Computer {
    private String CPU;
    private String RAM;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "]";
    }

    public static class Builder {
        private String CPU;
        private String RAM;

        public Builder() {
            this.CPU = "";
            this.RAM = "";
        }

        public Builder CPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder RAM(String RAM) {
            this.RAM = RAM;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}


class Director {
    public  Computer.Builder builder;

    public Director(Computer.Builder builder) {
        this.builder = builder;
    }

    public Computer buildLaptop() {
        return this.builder
            .CPU("Laptop CPU")
            .RAM("Laptop RAM")
            .build();
    }


    public Computer buildDesktop() {
        return this.builder
            .CPU("Desktop CPU")
            .RAM("Desktop RAM")
            .build();
    }

}


public class BuilderApp {
    public static void main(String[] args) {
        Computer.Builder builder = new Computer.Builder();
        Director director = new Director(builder);

        Computer laptop = director.buildLaptop();
        Computer desktop = director.buildDesktop();
        System.out.println(laptop);
        System.out.println(desktop);
    }
}







