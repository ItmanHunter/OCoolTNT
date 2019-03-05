package com.ocoolcraft.plugin.blocks.processor;

import com.ocoolcraft.plugin.config.Config;
import org.bukkit.block.Block;

public abstract class BlockProccessor {

    private double destory, drop;

    public double getDestory() {
        return destory;
    }

    public void setDestory(double destory) {
        this.destory = destory;
    }

    public double getDrop() {
        return drop;
    }

    public void setDrop(double drop) {
        this.drop = drop;
    }

    public abstract void processBlock(Block block, Config config);
}
