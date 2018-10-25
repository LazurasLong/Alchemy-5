package me.elizabethlfransen.alchemy.capabilities.endflux

/**
 * Compatibility interface for EndFlux.
 */
interface IEndFluxHandler {
    /**
     * The amount of the stored EndFlux.
     */
    val storedEndFlux: Int

    /**
     * The efficiency of the stored EndFlux.
     */
    val storedEfficiency: Double

    /**
     * Sets the stored end flux at the given [amount] at [efficiency].
     * If [simulate] is true, This action is simulated
     *
     * @return The amount of flux accepted
     */
    fun setStoredEndFlux(amount: Int, efficiency: Double = storedEfficiency, simulate: Boolean = false): Int

    /**
     * Adds to the stored end flux at the given [amount] at [efficiency].
     * If [simulate] is true, This action is simulated
     *
     * @return The amount of flux accepted
     */
    fun acceptEndFlux(amount: Int, efficiency: Double, simulate: Boolean = false): Int

}