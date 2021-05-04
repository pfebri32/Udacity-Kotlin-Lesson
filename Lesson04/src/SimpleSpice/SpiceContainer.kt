package SimpleSpice

data class SpiceContainer(
    val spice: Spice
) {
    val label = spice.name
}