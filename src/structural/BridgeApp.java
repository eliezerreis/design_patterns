/*
 * The Bridge Design Pattern splits a large class into multiples independent hierarchies
 *
 * Why use it?
 * - When we have multiple variations in one abstraction
 * - When you need to integrate with third-party or legacy systems that you cannot modify.
 *
 * Pros:
 * - Flexibility
 * - Extensibility
 * - Decoupling
 * - Separation of concerns
 */

package structural;

interface Color {
    void fill();
}

class Red implements Color {
    public void fill() {
        System.out.println("Red");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Blue");
    }
}

abstract class Shape {
    protected Color color;
    protected Shape(Color color) {
        this.color = color;
    }
    abstract void draw();
}

class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Circle");
        color.fill();
    }
}


class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Rectangle");
        color.fill();
    }
}

public class BridgeApp {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();

        Shape circle = new Circle(red);
        Shape rectangle = new Rectangle(blue);
        circle.draw();
        rectangle.draw();
    }
}
