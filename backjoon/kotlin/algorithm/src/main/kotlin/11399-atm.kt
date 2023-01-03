import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val ps = mutableListOf<Int>()

    for (i in 1..n) {
        ps.add(nextInt())
    }

    for (i in 1 until ps.size) {
        var minIdx = i
        for (j in i - 1 downTo 0) {
            if (ps[i] < ps[j]) {
                minIdx = j
            } else break
        }
        val removedItem = ps.removeAt(i)
        ps.add(minIdx, removedItem)
    }

    val sumArr = ps.toIntArray()

    for (i in 1 until ps.size) {
        sumArr[i] = (ps[i] + sumArr[i - 1])
    }

    var result = 0

    for (i in sumArr) {
        result += i
    }

    println(result)
}