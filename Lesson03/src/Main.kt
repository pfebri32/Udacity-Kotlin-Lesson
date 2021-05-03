import java.util.*

val weekDays: Array<String> = arrayOf(
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
)

val decorations = listOf(
    "rock",
    "pagoda",
    "plastic plant",
    "alligator",
    "flower pot",
)

fun main(args: Array<String>) {
    // Main Lesson
    feedTheFish()
    val filtered = decorations.filter { it[0] == 'p' }
    println(filtered)

    // 11. Fit More Fish
    canAddFish(10.0, listOf(3,3,3)) /*---> false*/
    canAddFish(8.0, listOf(2,2,2), hasDecorations = false) /*---> true*/
    canAddFish(9.0, listOf(1,1,3), 3) /*---> false*/
    canAddFish(10.0, listOf(), 7, true) /*---> true*/

    // 3. Practice Time
    // Print day of week name.
    dayOfWeek()

    // 5. Practice Time
    // Arguments and string templates.
    val greet = if (args[0].toInt() < 12) "morning" else "night"
    println("Good $greet, Kotlin")

    // 7. Practice Time
    // Insert 6 to skip.
    var fortuneLoop = 0
    while(fortuneLoop < 10) {
        val fortune = getFortuneCookie()
        println("Your fortune is:")
        println(fortune)
        if (fortune.contains("Take it easy")) break
        fortuneLoop++
    }

    // 13. Practice Time
    // 15. Practice Time
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))

    // 17. Practice Time
    val spices = listOf(
        "curry",
        "pepper",
        "cayenne",
        "ginger",
        "red curry",
        "green curry",
        "red pepper",
    )
    println(spices.filter{ it.contains("curry") }.sortedBy{ it.length })
    println(spices.filter{ it.startsWith('c') && it.endsWith('e') })
    println(spices.take(3).filter{ it.startsWith('c') })

    // 19. Practice Time
    val rollDice = { sides: Int ->
        if (sides <= 0)  0
        else Random().nextInt(sides) + 1
    }
    val rollDice2: (Int) -> Int = { sides ->
        if (sides <= 0)  0
        else Random().nextInt(sides) + 1
    }

    println(rollDice(12))
    println(rollDice2(12))

    gamePlay(rollDice2)
    gamePlay(rollDice2)
}

fun gamePlay(rollADice: (Int) -> Int) {
    println(rollADice(12))
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "sunny",
    temperature: Int = 24,
) : String = when {
    isMoodHappy(mood) && isWeatherSunny(weather) -> "go for walk"
    isMoodSad(mood) && isWeatherRainy(weather) && isCold(temperature) -> "say in bed"
    isHot(temperature) -> "go swimming"
    else -> "Stay home and read."
}

fun isMoodHappy(mood: String) = mood == "happy"
fun isMoodSad(mood: String) = mood == "sad"
fun isWeatherSunny(weather: String) = weather == "sunny"
fun isWeatherRainy(weather: String) = weather == "rainy"
fun isCold(temperature: Int) = temperature <= 0
fun isHot(temperature: Int) = temperature > 35

fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true,
) = println(fitMoreFish(tankSize, currentFish, fishSize, hasDecorations))

fun fitMoreFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true,
) : Boolean {
    val sumFish = currentFish.sum() + fishSize

    val tankSizeAvailable = if (hasDecorations) tankSize * 8 / 10
    else tankSize

    if (sumFish <= tankSizeAvailable) return true
    return false
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20,
) = true

fun getFortuneCookie() : String {
    val listOfFortune: Array<String> = arrayOf(
        "You will have a great day!",
        "Thing will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.",
    )

    println("Enter your birthday:")
    val birthday: Int = readLine()?.toIntOrNull() ?: 1

    if (birthday < 1) return "Error: Minimal input is 1."
    return listOfFortune[(birthday - 1).rem(listOfFortune.size)]
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the fist eat $food")

    if (shouldChangeWater(day)) println("Change the water today!")
}

fun fishFood(day: String) : String = when (day) {
    "Monday" -> "flakes"
    "Tuesday" -> "pellets"
    "Wednesday" -> "redworms"
    "Thursday" -> "granules"
    "Friday" -> "mosquitoes"
    "Saturday" -> "lettuce"
    "Sunday" -> "plankton"
    else -> "fasting"
}

fun randomDay() = weekDays[Random().nextInt(7)]

fun dayOfWeek() {
    val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(weekDays[calendarDayOfWeek - 1])
}