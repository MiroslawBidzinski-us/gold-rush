package edu.io.token;

public class PickaxeToken extends Token implements Tool, Repairable {
    private final double gainFactor;
    private final int durability;
    private int currentDurability;
    private Token withToken;

    public PickaxeToken() {
        this(1.5, 3);
    }

    public PickaxeToken(double gainFactor) {
        this(gainFactor, 3);
    }

    public PickaxeToken(double gainFactor, int durability) {
        super(Label.PICKAXE_TOKEN_LABEL);
        if (durability <= 0) throw new IllegalArgumentException("Durability must be positive");
        if (gainFactor < 1) throw new IllegalArgumentException("GainFactor cannot be lower than 1");
        this.gainFactor = gainFactor;
        this.durability = durability;
        this.currentDurability = durability;

    }

    public boolean isBroken() {
        return currentDurability <= 0;
    }

    public double gainFactor() {
        return gainFactor;
    }

    public int durability() {
        return currentDurability;
    }

    @Override
    public Tool useWith(Token token) {
        this.withToken = token;
        return this;
    }

    @Override
    public Tool ifWorking(Runnable action) {
        if (withToken instanceof GoldToken && !isBroken()) {
            use();
            action.run();
        }
        return this;
    }

    @Override
    public Tool ifBroken(Runnable action) {
        if (isBroken()) action.run();
        return this;
    }


    @Override
    public Tool ifIdle(Runnable action) {
        if (!(withToken instanceof GoldToken)) action.run();
        return this;
    }

    public void use() {
        currentDurability = currentDurability - 1;
    }

    public void repair() {
        currentDurability = durability;
    }
}
