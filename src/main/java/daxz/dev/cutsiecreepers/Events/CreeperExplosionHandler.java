package daxz.dev.cutsiecreepers.Events;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperExplosionHandler implements Listener {

    @EventHandler
    public void onExplosion(EntityExplodeEvent event){

        Entity entity = event.getEntity();
        System.out.println(entity.getName());
        if (!entity.getName().equals("creeper")){ return; }


    }


}
