package com.ocoolcraft.plugin.blocks.processor;

import com.ocoolcraft.plugin.config.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class TNTProcessor extends BlockProccessor {
    @Override
    public void processBlock(Block block, Config config) {
        if (block.getType().equals(Material.TNT) && config.getNextTNT().isExplode()) {
            block.setType(Material.AIR);
            TNTPrimed tnt = block.getWorld().spawn(block.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(40);
            Vector v = new Vector(block.getX() - config.getPosition().getEventX(),
                    block.getX() - config.getPosition().getEventX(),
                    block.getZ() - config.getPosition().getEventZ()).normalize();
            tnt.setVelocity(v);
        }
    }

}
