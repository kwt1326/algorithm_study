import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var result = false
    val node = nextInt()
    val edge = nextInt()

    val ijList = Array<ArrayList<Int>>(node) { arrayListOf() }
    val checks = BooleanArray(node) { false }

    for (i in 1..edge) {
        val p1 = nextInt()
        val p2 = nextInt()
        ijList[p1].add(p2)
        ijList[p2].add(p1)
    }

    fun dfs(v: Int, dep: Int) {
        if (dep == 5 || result) {
            result = true
            return
        }

        checks[v] = true
        for (vv in ijList[v]) {
            if (!checks[vv]) {
                dfs(vv, dep + 1)
            }
        }
        checks[v] = false // ?? 아마도.. 다시 이 노드로 왔을때 depth 혹은 result == true 여부를 체크하려고 하는 듯?
    }

    for (v in 0 until node) {
        dfs(v, 1)
        if (result) break
    }

    println(if (result) 1 else 0)
}