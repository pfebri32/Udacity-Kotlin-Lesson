package SimpleSpice

abstract class Spice(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor,
) : SpiceColor by color {
    val heat: Int
        get() = when (spiciness) {
            "insanely hot" -> 10
            "hot" -> 7
            "mild" -> 5
            "very mild" -> 3
            "very very mild" -> 1
            else -> 0
        }

    init {
        println("The spice name is $name. With $spiciness spiciness. Level $heat of heat.")
    }

    abstract fun prepareSpice()
}

interface Grinder {
    fun grind() {
        println("Grind.")
    }
}

enum class COLOR(val color: Int) {
    YELLOW(0xFFFF00)
}

interface SpiceColor {
    val color: COLOR
}

object YellowSpiceColor: SpiceColor {
    override val color = COLOR.YELLOW
}

class Curry(
    name: String,
    spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor,
) : Spice(name, spiciness, color), Grinder {
    override fun prepareSpice() {
        grind()
    }
}