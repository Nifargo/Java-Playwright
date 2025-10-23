package org.project.commonUse.PlayItRight;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigCache;

@UtilityClass
public class ConfigManager {

    public static ConfigAllure config() {
        return ConfigCache.getOrCreate(ConfigAllure.class);
    }
}
