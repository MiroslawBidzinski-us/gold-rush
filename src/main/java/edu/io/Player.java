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

    private double validateAmount(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Wartość złota nie może być ujemna");
        return amount;
    }

    public void gainGold(double amount) throws IllegalArgumentException {
        this.gold += validateAmount(amount);
    }

    public void loseGold(double amount) throws IllegalArgumentException {
        this.gold = validateAmount(this.gold - validateAmount(amount));
    }

    public void interactWithToken(Token token) {

        if (token instanceof GoldToken goldToken) {
            gainGold(goldToken.amount());
        }
    }
}