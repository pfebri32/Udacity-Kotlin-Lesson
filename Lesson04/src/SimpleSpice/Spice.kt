package SimpleSpice

abstract class Spice(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor,
) : SpiceColor by color {
    val heat: Int
        get() = when {
            spiciness == "insanely hot" -> 10
            spiciness == "hot" -> 7
            spiciness == "mild" -> 5
            spiciness == "very mild" -> 3
            spiciness == "very very mild" -> 1
            else -> 0
        }

    init {
        println("The spice name is $name. With $spiciness spiciness. Level $heat of heat.")
    }

    abstract fun prepareSpice()

    fun makeSalt() {
        println("Make salt.")
    }
}

interface Grinder {
    fun grind() {
        println("Grind.")
    }
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor: SpiceColor {
    override val color = "yellow"
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