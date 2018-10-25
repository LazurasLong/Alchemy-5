package me.elizabethlfransen.alchemy

import me.elizabethlfransen.alchemy.Alchemy.MODID
import me.elizabethlfransen.alchemy.capabilities.Capabilities
import me.elizabethlfransen.alchemy.config.ConfigurationManager
import me.elizabethlfransen.alchemy.registry.EmcRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = MODID, modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object Alchemy {

    // region constants

    const val MODID = "alchemy"

    // endregion constants

    /** Initialization event for the alchemy mod */
    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        Capabilities.register()
        ConfigurationManager.General.emcValues.forEach(EmcRegistry::register)
    }
}