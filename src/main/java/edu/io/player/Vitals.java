package edu.io.player;

import java.util.Objects;

public class Vitals {
    private int hydration;
    private Runnable onDeathHandler = () -> {
    };

    public Vitals() {
        this(100);
    }

    public Vitals(int hydration) {
        this.hydration = hydration;
    }

    public int hydration() {
        return hydration;
    }

    public void hydrate(int waterAmount) {
        if (waterAmount < 0 || waterAmount > 100)
            throw new IllegalArgumentException("Hydration should be a value between 0 and 100");
        int updatedHydration = this.hydration + waterAmount;
        this.hydration = Math.min(updatedHydration, 100);
    }


    public void dehydrate(int waterAmount) {

        if (waterAmount < 0 || waterAmount > 100)
            throw new IllegalArgumentException("Hydration should be a value between 0 and 100");
        hydration = Math.max(0, this.hydration - waterAmount);
        if (!isAlive()) onDeathHandler.run();
    }

    public boolean isAlive() {
        return this.hydration > 0;
    }

    public void setOnDeathHandler(Runnable handler) throws NullPointerException {
        this.onDeathHandler = Objects.requireNonNull(handler, "onDeathHandler cannot be null");
    }
}

