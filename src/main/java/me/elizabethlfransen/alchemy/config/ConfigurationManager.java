package me.elizabethlfransen.alchemy.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
    }
}
