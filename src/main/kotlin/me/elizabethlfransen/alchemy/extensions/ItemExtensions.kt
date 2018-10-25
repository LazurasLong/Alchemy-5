package me.elizabethlfransen.alchemy.extensions

import net.minecraft.item.ItemStack

/**
 * The EMC value of the ItemStack,
 * This is null if the item stack doesn't have an emc value
 */
val ItemStack.emcValue: Int?
    get() = 0 // TODO implement this plz