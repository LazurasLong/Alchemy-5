package me.elizabethlfransen.alchemy.compatibility.enderflux

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class EnderFluxAcceptorStorage : Capability.IStorage<IEnderFluxAcceptor> {
    override fun readNBT(
        capability: Capability<IEnderFluxAcceptor>?,
        instance: IEnderFluxAcceptor?,
        side: EnumFacing?,
        nbt: NBTBase?
    ) {
    }

    override fun writeNBT(
        capability: Capability<IEnderFluxAcceptor>?,
        instance: IEnderFluxAcceptor?,
        side: EnumFacing?
    ): NBTBase? {
        return null
    }
}