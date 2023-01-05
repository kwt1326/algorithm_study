import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()

    // 상-하-좌-우 이동 패턴
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)
    val checks = Array(n) { BooleanArray(m) { false } }
    val maze = Array(n) { Array(m) { 0 } }

    // init maze data
    for (i in 0 until n) {
        val row = next() // nextInt 는 overflow 가 일어난다.
        for (j in 0 until m) {
            maze[i][j] = row[j].digitToInt()
        }
    }

    fun bfs(firstX: Int, firstY: Int) {
        val queue = ArrayDeque<Array<Int>>()
        queue.addLast(arrayOf(firstX, firstY))
        checks[firstX][firstY] = true

        while (!queue.isEmpty()) {
            val node = queue.removeFirst()

            for (k in 0 until 4) {
                val x = node[0] + dx[k] // x 가 수직방향인듯 하다.
                val y = node[1] + dy[k] // y 가 수평방향인듯 하다.

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (maze[x][y] != 0 && !checks[x][y]) {
                        checks[x][y] = true
                        maze[x][y] = maze[node[0]][node[1]] + 1

                        // debug
                        // val value = maze[x][y]
                        // println("$x $y dep:$value")

                        queue.addLast(arrayOf(x, y))
                    }
                }
            }
        }
    }

    bfs(0, 0)

    // maze 배열에 업데이트 된 도착지의 최종 depth 출력
    println(maze[n - 1][m - 1])
}