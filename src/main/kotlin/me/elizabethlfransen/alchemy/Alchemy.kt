package me.elizabethlfransen.alchemy

import me.elizabethlfransen.alchemy.Alchemy.MODID
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = MODID, modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object Alchemy {

    // region constants

    const val MODID = "alchemy";

    // endregion constants

    /** Initialization event for the alchemy mod */
    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
    }
}