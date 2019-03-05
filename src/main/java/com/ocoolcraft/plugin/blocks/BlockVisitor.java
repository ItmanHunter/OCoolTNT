package com.ocoolcraft.plugin.blocks;

import com.ocoolcraft.plugin.blocks.processor.BlockProccessor;
import com.ocoolcraft.plugin.blocks.processor.DestoryBlock;
import com.ocoolcraft.plugin.blocks.processor.TNTProcessor;
import com.ocoolcraft.plugin.config.Config;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockVisitor {

    private List<BlockProccessor> processors;

    public void prepare() {
        processors = new ArrayList<>();
        processors.add(new DestoryBlock());
        processors.add(new TNTProcessor());
    }

    public void visitEvent(ExplosionPrimeEvent event, Config config) {
         Entity tntEntity = event.getEntity();
         Location location = tntEntity.getLocation();
         int radius = config.getRadius();

         World world = location.getWorld();

         for(int dx=-radius;dx<=radius;dx++) {
             for(int dy=-radius;dy<=radius;dy++) {
                 for(int dz=-radius;dz<=radius;dz++) {
                     Block block = world.getBlockAt(
                             location.getBlockX()+dx,
                             location.getBlockY()+dy,
                             location.getBlockZ()+dz);
                     System.out.println(block.toString());
                     for (BlockProccessor proccessor:processors) {
                         proccessor.processBlock(block,config);
                     }
                 }
             }
         }
    }

}
