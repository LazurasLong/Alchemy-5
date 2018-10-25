package me.elizabethlfransen.alchemy.registry

import me.elizabethlfransen.alchemy.extensions.sortedOreDicNamesDescending
import net.minecraft.item.ItemStack

object EmcRegistry {
    private val emcValues = HashMap<String, Int>()
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
        emcValues[selector] = value
    }

    /**
     * Gets the EMC value of an itemStack
     * @return The EMC Value of the itemStack. If there is no EMC value registered, null is returned
     */
    fun getItemValue(itemStack: ItemStack): Int? {
        val registry = itemStack.item.registryName
        if (registry != null) {
            val name = registry.toString()
            // Full name is the name with metadata
            val fullName = "$name:${itemStack.metadata}"

            // If full name is present, otherwise check name without meta
            if (fullName in emcValues)
                return emcValues[fullName]
            else if (name in emcValues)
                return emcValues[fullName]
        }
        // could not find with name and meta; check OreDictionary
        // OreDictionary names are sorted with names with the most capital letters first
        val name = itemStack.sortedOreDicNamesDescending.firstOrNull {
            "ore:$it" in emcValues
        }

        // If an OreDictionary name is present show it here
        if (name != null)
            return emcValues["ore:name"]
        return null
    }
}