package me.elizabethlfransen.alchemy.extensions

import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

/**
 * The EMC value of the ItemStack,
 * This is null if the item stack doesn't have an emc value
 */
val ItemStack.emcValue: Int?
    get() = 0 // TODO implement this plz

val ItemStack.sortedOreDicNames: List<String>
    get() = OreDictionary.getOreIDs(this)
        .map { id -> OreDictionary.getOreName(id) }
        .sortedBy { name -> name.count { c -> c.isUpperCase() } }

val ItemStack.sortedOreDicNamesDescending: List<String>
    get() = OreDictionary.getOreIDs(this)
        .map { id -> OreDictionary.getOreName(id) }
        .sortedByDescending { name -> name.count { c -> c.isUpperCase() } }