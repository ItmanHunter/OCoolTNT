package com.ocoolcraft.plugin.config;

public class ConfigLoader {

    private static Entity getEntity() {
        Entity entity = new Entity();
        entity.setDamage(5.0D);
        entity.setBlindness(true);
        entity.setFire(true);
        entity.setNauesa(true);
        return entity;
    }

    public static Config getDefaultConfig() {
        Config config = new Config();
        config.setRadius(4);
        config.setName("OCoolTNT");

        config.setEntity(getEntity());
        config.setNextTNT(getNextTnT());
        config.setSound(getSound());
        config.setBlock(getBlock());

        return config;
    }

    private static NextTNT getNextTnT() {
        NextTNT nextTNT = new NextTNT();
        nextTNT.setExplode(true);
        return nextTNT;
    }

    private static Block getBlock() {
        Block block = new Block();
        block.setDestory(60.0D);
        block.setFire(60.0D);
        block.setDrop(60.0D);
        return block;
    }

    private static Sound getSound() {
        Sound sound = new Sound();
        sound.setVolume(1.0F);
        sound.setPitch(1.0F);
        return sound;
    }

    public static Config getConfig(String configName) {
        return getDefaultConfig();
    }

}
