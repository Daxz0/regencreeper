package daxz.dev.cutsiecreepers.Events;

import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class BlockRecovery {

    public static void updateBlock(Block block, BlockData data) {
        block.setBlockData(data);
        Particle.HEART.builder()
                .location(block.getLocation())
                .offset(0.5,0.5,0.5)
                .count(3)
                .spawn()

        ;
    }


}
