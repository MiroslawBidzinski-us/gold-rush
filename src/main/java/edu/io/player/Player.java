package edu.io.player;

import edu.io.token.*;

public class Player {
    private PlayerToken token;
    private final Shed shed = new Shed();
    public Gold gold = new Gold();

    private void usePickaxeOnGold(PickaxeToken pickaxe, GoldToken goldToken) {
        pickaxe.useWith(goldToken)
                .ifWorking(() -> {
                    gold.gain(goldToken.amount() * pickaxe.gainFactor());
                })
                .ifBroken(() -> {
                    gold.gain(goldToken.amount());
                    shed.dropTool();

                })
                .ifIdle(() -> {
                });
    }

    public void assignToken(PlayerToken token) {
        this.token = token;
    }

    public PlayerToken token() {
        return token;
    }

    public void gainGold(double amount) throws IllegalArgumentException {
        this.gold.gain(amount);
    }

    public void loseGold(double amount) throws IllegalArgumentException {
        this.gold.lose(amount);
    }


    public void interactWithToken(Token token) {

        switch (token) {
            case GoldToken goldToken -> {
                if (shed.getTool() instanceof PickaxeToken pickaxe) usePickaxeOnGold(pickaxe, goldToken);
                else gold.gain(goldToken.amount());
            }
            case PickaxeToken pickaxeToken -> shed.add(pickaxeToken);
            case AnvilToken anvilToken -> {
                if (shed.getTool() instanceof PickaxeToken pickaxe) pickaxe.repair();
            }
            default -> {
            }
        }
    }
}