package me.elizabethlfransen.alchemy.capabilities

import me.elizabethlfransen.alchemy.capabilities.endflux.EndFluxHandler
import me.elizabethlfransen.alchemy.capabilities.endflux.IEndFluxHandler
import net.minecraftforge.common.capabilities.CapabilityManager

object Capabilities {
    fun register() {
        CapabilityManager.INSTANCE.register<IEndFluxHandler>(
            IEndFluxHandler::class.java,
            EndFluxHandler.Storage
        ) { EndFluxHandler() }
    }
}