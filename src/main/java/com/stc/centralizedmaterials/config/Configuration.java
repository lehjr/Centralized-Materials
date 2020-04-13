package com.stc.centralizedmaterials.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class Configuration {

    public static Common COMMON;
    public static ForgeConfigSpec COMMON_SPEC;

    public static void init() {
        Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonPair.getRight();
        COMMON = commonPair.getLeft();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
    }

    public static class Common {

        public ForgeConfigSpec.BooleanValue showNewUpdateNotifications;

        private Common(ForgeConfigSpec.Builder builder) {
            builder.push("General");
            showNewUpdateNotifications = builder
                    .comment("Enables/Disables New update notification [false/true|default:true]")
                    .translation("text.configuration.show_new_update_notifications")
                    .define("new_update_notifications", true);
            builder.pop();
        }
    }
}