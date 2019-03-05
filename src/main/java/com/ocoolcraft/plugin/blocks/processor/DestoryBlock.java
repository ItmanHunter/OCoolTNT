package com.ocoolcraft.plugin.blocks.processor;

import com.ocoolcraft.plugin.config.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class DestoryBlock extends BlockProccessor {

    @Override
    public void processBlock(Block block, Config config) {
        if (block.getType().isSolid()) {
            if (Math.random()*100 <= config.getBlock().getDestory()) {
                    Material material = block.getType();
                    generateFallingBlock(block,config);
                }
            block.setType(Material.AIR);
            }
        }

    private void generateFallingBlock(Block block, Config config) {
        FallingBlock fblock = block.getWorld().spawnFallingBlock(
                block.getLocation(), block.getType(), block.getData());
        Vector v = new Vector(-block.getX() + config.getPosition().getEventX(),
                block.getY() - config.getPosition().getEventY(),
                -block.getZ() + config.getPosition().getEventZ()).normalize();
        fblock.setVelocity(v);
        fblock.setDropItem(false);
    }
}
