package edu.io.player;

import edu.io.token.*;

import java.util.Objects;

public class Player {
    private PlayerToken token;
    private final Shed shed = new Shed();
    public Gold gold = new Gold();
    public final Vitals vitals = new Vitals();
    public Player() {
        vitals.setOnDeathHandler(() -> System.out.println("Koniec gry!"));
    }

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

        this.token = Objects.requireNonNull(token, "Token cannot be null");
    }

    public PlayerToken token() {

        return token;
    }

    public void interactWithToken(Token token) {
        if (!vitals.isAlive()) throw new IllegalStateException("Gracz nie żyje");
        switch (Objects.requireNonNull(token, "Token cannot be null")) {
            case GoldToken goldToken -> {
                if (shed.getTool() instanceof PickaxeToken pickaxe) usePickaxeOnGold(pickaxe, goldToken);
                else gold.gain(goldToken.amount());
                vitals.dehydrate(VitalsValues.DEHYDRATION_GOLD);
            }
            case PickaxeToken pickaxeToken -> shed.add(pickaxeToken);
            case AnvilToken anvilToken -> {
                if (shed.getTool() instanceof Repairable repairable) {
                    repairable.repair();
                    vitals.dehydrate(VitalsValues.DEHYDRATION_ANVIL);
                }

            }
            case WaterToken water -> vitals.hydrate(water.amount());
            default -> vitals.dehydrate(VitalsValues.DEHYDRATION_MOVE);
        }
    }
}