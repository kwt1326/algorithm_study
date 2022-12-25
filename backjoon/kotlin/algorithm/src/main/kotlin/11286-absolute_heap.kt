import java.util.*
import kotlin.Comparator
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()

    val pQueue = PriorityQueue<Int>(Comparator { a, b ->
        val aa = abs(a)
        val ab = abs(b)
        if (aa == ab) {
            if (a > b) 1 else -1
        } else {
            aa - ab
        }
    })

    for (i in 1..n) {
        val v = nextInt()
        if (v == 0 && pQueue.isEmpty()) {
            println(0)
        } else if (v != 0) {
            pQueue.add(v)
        } else {
            println(pQueue.poll())
        }
    }
}