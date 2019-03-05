package com.ocoolcraft.plugin.entity;

import com.ocoolcraft.plugin.config.Config;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class EntityVisitor {

    public void visitEvent(ExplosionPrimeEvent event, Config config) {
        Entity en = event.getEntity();
        for (Entity currentEntity : en.getWorld().getEntities()) {
            Location midloc = en.getLocation();
            Location ploc = currentEntity.getLocation();
            int xr = midloc.getBlockX() - ploc.getBlockX();
            int yr = midloc.getBlockY() - ploc.getBlockY();
            int zr = midloc.getBlockZ() - ploc.getBlockZ();

            if (currentEntity.getLocation().distance(en.getLocation()) < 5.0D) {
                Vector v = new Vector(xr, yr, zr).normalize();
                v.multiply(0.8D);
                v.setY(0.5D);
                currentEntity.setVelocity(v);
                if ((currentEntity instanceof Player)) {
                    Player currentPlayer = ((Player)currentEntity).getPlayer();
                    if ((currentPlayer.getGameMode().equals(GameMode.SURVIVAL)) || (currentPlayer.getGameMode().equals(GameMode.ADVENTURE))) {
                        applyEffects(currentPlayer,config.getEntity());
                    }
                }
            }
        }
    }

    private void applyEffects(Player currentPlayer, com.ocoolcraft.plugin.config.Entity configEntity) {
        currentPlayer.setHealth(
                Math.min(currentPlayer.getHealth() - configEntity.getDamage(),0D)
        );
        if (configEntity.isBlindness()) {
            PotionEffect potionEffect = new PotionEffect(
                    PotionEffectType.BLINDNESS,
                    200,
                    4
            );
            currentPlayer.addPotionEffect(
                    potionEffect
            );
        }
        if (configEntity.isNauesa()) {
            PotionEffect potionEffect = new PotionEffect(
                    PotionEffectType.CONFUSION,
                    200,
                    4
            );
            currentPlayer.addPotionEffect(
                    potionEffect
            );
        }
        if (configEntity.isFire()) {
            currentPlayer.setFireTicks(100);
        }
        if (configEntity.isNauesa()) {
            PotionEffect potionEffect = new PotionEffect(
                    PotionEffectType.CONFUSION,
                    200,
                    4
            );
            currentPlayer.addPotionEffect(
                    potionEffect
            );
        }
    }

}
