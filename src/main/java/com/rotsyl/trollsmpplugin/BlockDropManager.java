package com.rotsyl.trollsmpplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

//only uses materials to make it easier on me, will change later.
public class BlockDropManager implements Listener {
     private HashMap<Material, Material> blockMap = new HashMap<>();

    public void addBlockDrop(Material block, ItemStack item) {
        if(blockMap.containsKey(block)) blockMap.remove(block);

        blockMap.put(block, item.getType());
    }

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) {
        Block block = event.getBlock();

        if(!blockMap.containsKey(block)) return;

        event.setCancelled(true);

        event.setDropItems(false);

        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(blockMap.get(block.getType())));
    }

    //singleton stuffs
    private static BlockDropManager instance;

    public static BlockDropManager getInstance() {
        if(instance == null) {
            instance = new BlockDropManager();
        }

        return instance;
    }

    private BlockDropManager() {}
}
