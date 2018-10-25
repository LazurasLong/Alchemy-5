package me.elizabethlfransen.alchemy.registry

import net.minecraft.item.ItemStack

object EmcRegistry {
    /**
     * Registers an item to the [EmcRegistry]
     * @param selector An item selector using the following syntax
     *  mod:item:meta
     *  meta is optional. If it is left out, it is defaulted to all meta.
     *  to use OreDictionary use "ore" for the mod.
     *  When registering items a priority system is used
     *  Highest priority to lowest:
     *  mod:item:meta
     *  mod:item
     *  ore:itemMajorMinor
     *  ore:itemMajor
     *  ore:item
     * @param value The Emc Value of the item
     */
    fun register(selector: String, value: Int) {
        // TODO
    }

    /**
     * Gets the EMC value of an itemStack
     * @return The EMC Value of the itemStack. If there is no EMC value registered, null is returned
     */
    fun getItemValue(itemStack: ItemStack): Int? {
        return null
    }
}