package com.rotsyl.trollsmpplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(BlockDropManager.getInstance(), this);
        BlockDropManager.getInstance().addBlockDrop(Material.DIRT, new ItemStack(Material.COBBLED_DEEPSLATE));
        // rotator likes men

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
