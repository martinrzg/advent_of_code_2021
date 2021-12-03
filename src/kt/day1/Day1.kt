package kt.day1

import readInput

fun main() {
    val input = readInput("input", day = 1)
    val testInput = listOf("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")

    fun part1(input: List<String>): Int {
        return input.zipWithNext().count { (a, b) -> a.toInt() < b.toInt() }
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3).map { it -> it.sumOf { it.toInt() } }.zipWithNext().count { (a, b) -> a < b }
    }


    println(part1(testInput))
    println(part2(testInput))

    println(part1(input))
    println(part2(input))
}