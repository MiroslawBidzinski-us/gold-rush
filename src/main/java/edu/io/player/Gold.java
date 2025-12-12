package edu.io.player;

public class Gold {
    private double amount;

    public Gold() {
        this(0);
    }

    public Gold(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount = amount;
    }

    public double amount() {
        return amount;
    }

    public void gain(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount += amount;
    }

    public void lose(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        double updatedAmount = this.amount - amount;
        if (updatedAmount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount = updatedAmount;
    }

}
