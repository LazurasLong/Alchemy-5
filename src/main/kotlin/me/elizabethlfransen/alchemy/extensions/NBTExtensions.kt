package me.elizabethlfransen.alchemy.extensions

import net.minecraft.nbt.NBTTagCompound

operator fun NBTTagCompound.set(key: String, value: Int) {
    this.setInteger(key, value)
}

operator fun NBTTagCompound.set(key: String, value: Double) {
    this.setDouble(key, value)
}