package daxz.dev.cutsiecreepers.Events;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import daxz.dev.cutsiecreepers.Cutsiecreepers;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreeperExplosionHandler implements Listener {

    @EventHandler
    public void onExplosion(EntityExplodeEvent event){


        Entity entity = event.getEntity();
        if (!(entity instanceof Creeper)) return;

        Location location = entity.getLocation();
        World world = location.getWorld();
        List<Block> blocks = event.blockList();

        Map<Block, BlockData> save = new HashMap<>();
        for (Block block : blocks) {
            save.put(block, block.getBlockData().clone());
        }

        int slowCount = 0;
        for (Map.Entry<Block, BlockData> entry : save.entrySet()) {
            slowCount++;
            Bukkit.getScheduler().runTaskLater(Cutsiecreepers.getInstance(), () -> {
                BlockRecovery.updateBlock(entry.getKey(), entry.getValue());
            }, 2+slowCount* 4L);
        }



    }


}
