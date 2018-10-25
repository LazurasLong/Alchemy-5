package me.elizabethlfransen.alchemy.capabilities.endflux

import me.elizabethlfransen.alchemy.extensions.set
import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability


open class EndFluxHandler(storedEndFlux: Int = 0, storedEfficiency: Double = 0.0) : IEndFluxHandler {

    override var storedEndFlux = storedEndFlux
        protected set

    override var storedEfficiency = storedEfficiency
        protected set


    override fun setStoredEndFlux(amount: Int, efficiency: Double, simulate: Boolean): Int {
        if (!simulate) {
            storedEndFlux = amount
            storedEfficiency = efficiency
        }
        return amount
    }

    override fun acceptEndFlux(amount: Int, efficiency: Double, simulate: Boolean): Int {
        if (!simulate) {
            // I refuse to divide by zero
            if (amount != 0) {
                // Empty flux case
                if (storedEndFlux == 0) {
                    storedEndFlux = amount
                } else {
                    // The new amount is going to be the sum of the two
                    val newAmount = storedEndFlux + amount

                    // To calculate the new efficiency we need a weighted average
                    // Calculate the weights
                    val storedWeight = storedEndFlux.toDouble() / newAmount
                    val newWeight = amount.toDouble() / newAmount

                    // Calculate the new efficiency
                    val newEfficiency = storedEfficiency * storedWeight + efficiency * newWeight

                    // Update the values
                    storedEndFlux = newAmount
                    storedEfficiency = newEfficiency
                }
            }
        }
        return amount
    }

    object Storage : Capability.IStorage<IEndFluxHandler> {

        override fun writeNBT(
            capability: Capability<IEndFluxHandler>,
            instance: IEndFluxHandler,
            side: EnumFacing
        ): NBTBase {
            val result = NBTTagCompound()
            result["storedEndFlux"] = instance.storedEndFlux
            result["storedEfficiency"] = instance.storedEfficiency
            return result
        }

        override fun readNBT(
            capability: Capability<IEndFluxHandler>,
            instance: IEndFluxHandler,
            side: EnumFacing,
            nbt: NBTBase
        ) {
            if (nbt is NBTTagCompound) {
                instance.setStoredEndFlux(nbt.getInteger("storedEndFlux"), nbt.getDouble("storedEfficiency"), false)
            }
        }
    }
}