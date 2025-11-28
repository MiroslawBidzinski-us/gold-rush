package edu.io;

import edu.io.token.*;

public class Player {
    private PlayerToken token;
    private double gold;

    public void assignToken(PlayerToken token) {
        this.token = token;
    }

    public PlayerToken token() {
        return token;
    }

    public double gold() {
        return gold;
    }


    public void gainGold(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Wartość złota nie może być ujemna");
        this.gold += amount;
    }

    public void loseGold(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Wartość złota nie może być ujemna");
        double updatedGoldAmount = this.gold - amount;
        if (updatedGoldAmount < 0) throw new IllegalArgumentException("Suma złota na koncie nie może być ujemna");
        this.gold = updatedGoldAmount;
    }

    public void interactWithToken(Token token) {

        if (token instanceof GoldToken goldToken) {
            gainGold(goldToken.amount());
        }
    }
}