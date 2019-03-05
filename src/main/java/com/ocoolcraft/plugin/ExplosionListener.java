package com.ocoolcraft.plugin;

import com.ocoolcraft.plugin.blocks.BlockVisitor;
import com.ocoolcraft.plugin.config.Config;
import com.ocoolcraft.plugin.config.ConfigLoader;
import com.ocoolcraft.plugin.config.Position;
import com.ocoolcraft.plugin.entity.EntityVisitor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionListener implements Listener {

    @EventHandler(priority= EventPriority.MONITOR)
    void onExplosion(ExplosionPrimeEvent event)  {
        this.event = event;
        this.config = ConfigLoader.getDefaultConfig();
        run();
    }

    private ExplosionPrimeEvent event;

    private Config config;

    public void run() {
        event.setCancelled(true);
        event.getEntity().getWorld().playSound(
                event.getEntity().getLocation(),
                org.bukkit.Sound.EXPLODE,
                config.getSound().getVolume(),
                config.getSound().getPitch());
        EntityVisitor entityVisitor = new EntityVisitor();
        BlockVisitor blockVisitor = new BlockVisitor();
        blockVisitor.prepare();
        config.setPosition(getPosition(event.getEntity().getLocation()));
        blockVisitor.visitEvent(event,config);
        entityVisitor.visitEvent(event,config);
    }

    private Position getPosition(Location location) {
        Position position = new Position();
        position.setEventX(location.getBlockX());
        position.setEventY(location.getBlockY());
        position.setEventZ(location.getBlockZ());
        return position;
    }

}
