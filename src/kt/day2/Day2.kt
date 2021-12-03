package kt.day2

import readInput

fun main() {
    val input = readInput("input", day = 2)
    val testInput = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")

    fun part1(input: List<String>): Int {
        val (horizontal, depth) = input.map { line ->
            line.split(" ").zipWithNext().first()
        }.fold(Pair(0, 0)) { acc, elem ->
            val (dir, amount) = elem
            when (dir) {
                "forward" -> acc.copy(first = acc.first + amount.toInt())
                "up" -> acc.copy(second = acc.second - amount.toInt())
                "down" -> acc.copy(second = acc.second + amount.toInt())
                else -> acc
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        val (horizontal, depth) = input.map { line ->
            line.split(" ").zipWithNext().first()
        }.fold(Triple(0, 0, 0)) { acc, elem ->
            val (dir, amount) = elem
            val (horizontal, depth, aim) = acc
            when (dir) {
                "forward" -> acc.copy(first = horizontal + amount.toInt(), second = depth + amount.toInt() * aim)
                "up" -> acc.copy(third = aim - amount.toInt())
                "down" -> acc.copy(third = aim + amount.toInt())
                else -> acc
            }
        }
        return horizontal * depth
    }

    println(part1(testInput))
    println(part2(testInput))

    println(part1(input))
    println(part2(input))
}


