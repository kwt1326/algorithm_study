import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(Scanner(System.`in`)) {
    val node = nextInt()
    val edge = nextInt()
    val start = nextInt()

    val ijList = Array<ArrayList<Int>>(node + 1) { arrayListOf() }

    var checks = BooleanArray(node + 1) { false }
    var result = ArrayDeque<Int>()

    for (i in 1..edge) {
        val p1 = nextInt()
        val p2 = nextInt()
        ijList[p1].add(p2)
        ijList[p2].add(p1)
    }

    for (i in 1..node) {
        ijList[i].sort()
    }

    fun dfs(v: Int) {
        if (checks[v]) return

        checks[v] = true
        result.addLast(v)

        for (i in 0 until ijList[v].size) {
            dfs(ijList[v][i])
        }
    }

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

    dfs(start)

    println(result.joinToString(" "))

    result.clear()
    checks = BooleanArray(node + 1) { false }

    bfs()

    println(result.joinToString(" "))
}