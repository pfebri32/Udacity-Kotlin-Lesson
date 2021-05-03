package Aquarium

import kotlin.math.PI

open class Aquarium(
    var height: Int = 10,
    var length: Int = 20,
    var width: Int = 30,
) {
    open var volume: Int
        get() = height * length * width / 1000
        set(value) { height = (value * 1000) / (width * length) }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        val tank = water + water * 0.1
        height = (tank / length * width).toInt()
    }
}

class TowerTank() : Aquarium() {
    override var water = volume * 0.8
    override var volume: Int
        get() = (height * length * width / 1000 * PI).toInt()
        set(value) { height = (value * 1000) / (width * length) }
}