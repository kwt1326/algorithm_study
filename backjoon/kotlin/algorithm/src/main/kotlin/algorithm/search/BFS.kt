package algorithm.search

import java.util.ArrayList

val node = 5
val edge = 5
val start = 3

val nodes = arrayOf(arrayOf(5, 4), arrayOf(5, 2), arrayOf(1, 2), arrayOf(3, 4), arrayOf(3, 1))

fun main() {
    val ijList = Array<ArrayList<Int>>(node + 1) { arrayListOf() }
    val checks = BooleanArray(node + 1) { false }
    val result = ArrayDeque<Int>()

    for (i in 1..edge) {
        val p1 = nodes[i - 1][0]
        val p2 = nodes[i - 1][1]
        ijList[p1].add(p2)
        ijList[p2].add(p1)
    }

    for (i in 1..node) {
        ijList[i].sort()
    }

    // 큐를 이용해 완전히 빌 때까지 반복한다.
    fun bfs() {
        val queue = ArrayDeque<Int>()
        checks[start] = true
        result.addLast(start)
        queue.addLast(start)

        while (!queue.isEmpty()) {
            val node = queue.removeFirst()

            for (i in 0 until ijList[node].size) {
                val vv = ijList[node][i]
                if (!checks[vv]) {
                    checks[vv] = true
                    result.addLast(vv)
                    queue.addLast(vv)
                }
            }
        }
    }

    bfs()

    println(result.joinToString(" "))
}