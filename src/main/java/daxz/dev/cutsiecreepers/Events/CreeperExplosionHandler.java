package daxz.dev.cutsiecreepers.Events;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import daxz.dev.cutsiecreepers.Cutsiecreepers;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.*;

public class CreeperExplosionHandler implements Listener {

    static Map<UUID, List<Location>> restoringBlocks = new HashMap<>();

    public static void clearRestoringBlock(UUID uuid){
        restoringBlocks.remove(uuid);
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onExplosion(EntityExplodeEvent event){


        Entity entity = event.getEntity();
        if (!(entity instanceof Creeper)) return;

        Location location = entity.getLocation();
        World world = location.getWorld();
        List<Block> blocks = event.blockList();

        restoringBlocks.put(entity.getUniqueId(), blocks.stream().map(Block::getLocation).toList());

        blocks.sort(Comparator.comparing(Block::getY));

        Map<Block, BlockData> save = new LinkedHashMap<>();
        for (Block block : blocks) {
            save.put(block, block.getBlockData().clone());
        }


        int slowCount = 0;
        int maxCount = save.entrySet().size();
        for (Map.Entry<Block, BlockData> entry : save.entrySet()) {
            slowCount++;
            int finalSlowCount = slowCount;
            Bukkit.getScheduler().runTaskLater(Cutsiecreepers.getInstance(), () -> {
                BlockRecovery.updateBlock(entry.getKey(), entry.getValue(), finalSlowCount, maxCount, entity.getUniqueId());
            }, 2+slowCount* 20L);
        }



    }

    @EventHandler
    public void onPlace (BlockPlaceEvent event){

        Location loc = event.getBlock().getLocation();

        if (restoringBlocks.values().stream().anyMatch(list -> list.contains(loc))){
            event.getPlayer().sendMessage(Component.text("You cannot place blocks in a regenerating hole!", NamedTextColor.DARK_RED));
            event.setCancelled(true);
        }

    }




}
