package daxz.dev.cutsiecreepers.Events;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import daxz.dev.cutsiecreepers.Cutsiecreepers;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.List;

public class CreeperExplosionHandler implements Listener {

    @EventHandler
    public void onExplosion(EntityExplodeEvent event){

        Entity entity = event.getEntity();
        if (!entity.getName().equals("Creeper")){ return; }

        List<Block> destroyedBlocks = event.blockList();

        if (Cutsiecreepers.getInstance().getConfig().getBoolean("CreeperExplosions")) {
            System.out.println("what");
        }


    }


}
