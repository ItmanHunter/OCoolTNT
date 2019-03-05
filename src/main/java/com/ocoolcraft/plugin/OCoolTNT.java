package com.ocoolcraft.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class OCoolTNT extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
        getLogger().info("Enabled OCoolTNT");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled OCoolTNT");
    }

}
