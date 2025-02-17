package behavioral;

/*
 * The Strategy design pattern is a behavioral design pattern that allows a class to change its behavior at runtime by selecting one of many strategies (or algorithms) to use for a particular operation. In other words, the Strategy pattern defines a family of algorithms, encapsulates each one of them, and makes them interchangeable, so the algorithm can vary independently from the clients that use it.
 *
 * Why use it?
 * - Multiple possible algorithms
 * - Context-specific behavior
 * - Avoiding Multiple conditions
 * - Simplifying Complex Class Design
 */

import java.time.LocalDate;

interface DiscountStrategy {
    double applyDiscount(double price);
}

class RegularDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

class BlackFridayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.5;
    }
}


class PriceCalculator {
    public DiscountStrategy strategy;

    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return this.strategy.applyDiscount(price);
    }
}


public class StrategyApp {
    public static void main(String[] args) {


        DiscountStrategy strategy = new RegularDiscount();

        LocalDate today = LocalDate.now();
        LocalDate blackFriday = LocalDate.of(2025, 11, 25);

        if (today.isEqual(blackFriday)) {
            strategy = new BlackFridayDiscount();
        }

        PriceCalculator priceCalculator = new PriceCalculator(strategy);
        System.out.println(priceCalculator.calculatePrice(1000d));
    }
}