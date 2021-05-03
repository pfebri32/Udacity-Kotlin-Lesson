package Aquarium

import SimpleSpice.Curry
import SimpleSpice.SimpleSpice
import SimpleSpice.Spice

fun main() {
    // Main
    buildAquarium()

    // 3. Practice Time
    val mySimpleSpice = SimpleSpice()
    println("The name of spice is ${mySimpleSpice.name}.")
    println("Level ${mySimpleSpice.heat} of spiciness.")

    // 5. Practice Time
    // 10. Override Practice Time
    /*val listOfSpices = listOf(
        Spice("Very Hot Curry", "insanely hot"),
        Spice("Hot Curry", "hot"),
        Spice("Mild Curry", "mild"),
        Spice("Very Mild Curry", "very mild"),
        Spice("Baby Curry", "very very mild"),
    )
    val filteredSpice = listOfSpices.filter { it.heat > 5 }
    for (spice in filteredSpice) println(spice.name)*/
    val myCurry = Curry("Indian Curry")
    myCurry.prepareSpice()
}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Height: ${myAquarium.height}")
    println("Length: ${myAquarium.length}")
    println("Width: ${myAquarium.width}")
    println("Volume: ${myAquarium.volume}L")

    val mySecondAquarium = Aquarium(10)
    println("Height: ${mySecondAquarium.height}")
    println("Length: ${mySecondAquarium.length}")
    println("Width: ${mySecondAquarium.width}")
    println("Volume: ${mySecondAquarium.volume}L")
}