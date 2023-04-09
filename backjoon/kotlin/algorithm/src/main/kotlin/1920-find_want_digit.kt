import java.util.*
import kotlin.collections.ArrayList

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val nArr = ArrayList<Int>()
    for (i in 0 until n) {
        nArr.add(nextInt())
    }
    val m = nextInt()
    nArr.sort()

    for (i in 1..m) {
        val t = nextInt()
        var s = 0
        var e = nArr.size - 1
        var found = 0

        while (s <= e) {
            val mid = (s + e) / 2
            val vv = nArr[mid]
            if (vv == t) {
                found = 1
                break
            } else if (mid > t) {
                e = mid - 1
            } else {
                s = mid + 1
            }
        }
        println(found)
    }
}

// 제대로 구현했고 TC 도 확인했지만.. 왜인지 틀렷다고 나온다. 하지만 BJ 채점시스템에 안맞은게 중요하지는 않을 것 같다.