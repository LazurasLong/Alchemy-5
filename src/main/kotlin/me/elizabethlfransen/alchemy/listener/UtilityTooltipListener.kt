package me.elizabethlfransen.alchemy.listener

import me.elizabethlfransen.alchemy.extensions.emcValue
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

/**
 * Listener for adding utility tooltips
 */
@Mod.EventBusSubscriber
object UtilityTooltipListener {
    @JvmStatic
    @SubscribeEvent
    fun onToolTip(event: ItemTooltipEvent) {
        if (event.flags.isAdvanced) {
            showEMCValue(event)
            controlTooltip(event)
        }
    }

    private fun controlTooltip(event: ItemTooltipEvent) {
        event.toolTip.add("Control Tooltip")
    }

    private fun showEMCValue(event: ItemTooltipEvent) {
        val value = event.itemStack.emcValue
        if (value != null)
            event.toolTip.add("EMC Value: $value")
    }
}