package me.elizabethlfransen.alchemy.compatibility.enderflux

class EnderFluxAcceptorDefaultImplementation : IEnderFluxAcceptor {
    override fun acceptEnderFlux(amount: Int, efficiency: Double, simulate: Boolean): Int {
        // Does nothing
        // But that's okay
        // :)
        return amount
    }
}