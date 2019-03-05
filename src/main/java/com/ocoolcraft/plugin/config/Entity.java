package com.ocoolcraft.plugin.config;

public class Entity {
    private double damage;
    private boolean fire, blindness, nauesa;

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public boolean isBlindness() {
        return blindness;
    }

    public void setBlindness(boolean blindness) {
        this.blindness = blindness;
    }

    public boolean isNauesa() {
        return nauesa;
    }

    public void setNauesa(boolean nauesa) {
        this.nauesa = nauesa;
    }
}