package me.elizabethlfransen.alchemy.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

import static me.elizabethlfransen.alchemy.Alchemy.MODID;
import static net.minecraftforge.common.config.Config.Type.INSTANCE;

@EventBusSubscriber
public class ConfigurationManager {
    @SubscribeEvent
    public void onConfigChangedEvent(OnConfigChangedEvent event)
    {
        if (event.getModID().equals(MODID))
        {
            ConfigManager.sync(MODID, INSTANCE);
        }
    }

    @Config(modid = MODID, name = MODID, type = INSTANCE)
    public static class General {
        @Config.RequiresMcRestart
        @Config.Comment({
                "A list of item EMC Values",
                "Syntax should be \"item id\": amount",
                "Item ID syntax is: ",
                "mod:item:meta",
                "If meta is left out, any meta will be accepted",
                "To use OreDictionary, use ore as the mod",
                "More specific item IDs will take priority over less specific",
                "Examples of most to least specific:",
                "minecraft:glass:0",
                "minecraft:glass",
                "ore:blockGlassColorless",
                "ore:blockGlass",
        })
        @Config.Name("emc_values")
        public static Map<String, Integer> emcValues = new HashMap<>();

        static {
            emcValues.put("ore:cobblestone", 1);
        }
    }
}
