package com.rotsyl.trollsmpplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        
        /* Change block drops - grass drops dirt and dirt drops grass (Funny #1) */
        Bukkit.getPluginManager().registerEvents(BlockDropManager.getInstance(), this);
        BlockDropManager.getInstance().addBlockDrop(Material.DIRT, new ItemStack(Material.GRASS_BLOCK));
        BlockDropManager.getInstance().addBlockDrop(Material.GRASS_BLOCK, new ItemStack(Material.DIRT));
        // sylin instanceof gay (result: true)

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
