package me.elizabethlfransen.alchemy.compatibility.enderflux

/**
 * Compatibility for accepting EnderFlux
 */
interface IEnderFluxAcceptor {
    /**
     * Accept enderFlux
     * @param amount The amount of enderFlux to accept
     * @param efficiency The efficiency of the enderFlux
     * @param simulate Whether or not this action should be simulated
     */
    fun acceptEnderFlux(amount: Int, efficiency: Double, simulate: Boolean = false): Int
}