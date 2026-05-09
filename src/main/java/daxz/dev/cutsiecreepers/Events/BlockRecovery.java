package daxz.dev.cutsiecreepers.Events;

import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import java.util.UUID;

public class BlockRecovery {

    public static void updateBlock(Block block, BlockData data, int slowCount, int maxCount, UUID uuid) {

        if (slowCount >= maxCount-1) {
            CreeperExplosionHandler.clearRestoringBlock(uuid);
            System.out.println("protection removed");
        }

        block.setBlockData(data);
        Particle.HEART.builder()
                .location(block.getLocation().add(0,1,0))
                .offset(0.5,0.5,0.5)
                .count(3)
                .spawn()

        ;
    }


}
