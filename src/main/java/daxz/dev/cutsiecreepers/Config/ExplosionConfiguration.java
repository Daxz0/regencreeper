package daxz.dev.cutsiecreepers.Config;

import java.util.HashMap;
import java.util.Map;

public class ExplosionConfiguration {

    private boolean destroysBlocks = true;
    private boolean regenerativeHoles = false;

    public ExplosionConfiguration(boolean rh, boolean db) {
        regenerativeHoles = rh;
        destroysBlocks = db;
    }

    public boolean isDestroysBlocks() {
        return destroysBlocks;
    }
    public boolean isRegenerativeHoles() {
        return regenerativeHoles;
    }


    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();

        data.put("regeneratesHoles", this.regenerativeHoles);
        data.put("destroysBlocks", this.destroysBlocks);
        return data;
    }

    public static ExplosionConfiguration deserialize(Map<String, Object> args) {
        return new ExplosionConfiguration(
                (boolean) args.get("regeneratesHoles"),
                (boolean) args.get("destroysBlocks")
        );
    }




}
