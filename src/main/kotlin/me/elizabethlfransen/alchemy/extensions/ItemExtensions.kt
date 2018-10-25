package me.elizabethlfransen.alchemy.extensions

import me.elizabethlfransen.alchemy.registry.EmcRegistry
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

/**
 * The EMC value of the ItemStack,
 * This is null if the item stack doesn't have an emc value
 */
val ItemStack.emcValue: Int?
    get() = EmcRegistry.getItemValue(this)

val ItemStack.sortedOreDicNames: List<String>
    get() = OreDictionary.getOreIDs(this)
        .map { id -> OreDictionary.getOreName(id) }
        .sortedBy { name -> name.count { c -> c.isUpperCase() } }

val ItemStack.sortedOreDicNamesDescending: List<String>
    get() = OreDictionary.getOreIDs(this)
        .map { id -> OreDictionary.getOreName(id) }
        .sortedByDescending { name -> name.count { c -> c.isUpperCase() } }