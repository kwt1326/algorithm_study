package algorithm.search

// BOJ 11724

class DFS(
    node: Int,
    edge: Int,
    arr: Array<Array<Int>>
) {
    // 인접 리스트, 동시 초기화 (계산 편의상 1 번째 인덱스 부터 데이터 초기화)
    private val injectionList: MutableList<MutableList<Int>> = MutableList(node + 1) { mutableListOf() }

    // 방문 여부 리스트, 동시 초기화
    private val checkList = BooleanArray(node + 1) { false }

    private var n = -1
    private var m = -1

    init {
        n = node
        m = edge

        // 양방향 에지 삽입
        for (j in 0 until m) {
            injectionList[arr[j][0]].add(arr[j][1])
            injectionList[arr[j][1]].add(arr[j][0])
        }
    }

    // 재귀 탐색 함수 (스택으로 구현 가능하나 재귀가 구현이 편함)
    private fun dfs(i: Int) {
        if (checkList[i]) return
        checkList[i] = true
        for (v in injectionList[i]) {
            if (!checkList[v]) {
                dfs(v)
            }
        }
    }

    fun search() {
        // 한번의 노드 연결 탐색 완료시 count++, 모든 탐색 완료 시 dfs 재귀 종료, dfs 수행 횟수인 count 출력
        var count = 0
        for (i in 1..n) {
            if (!checkList[i]) {
                count++
                dfs(i)
            }
        }
        println(count)
    }
}

fun main() {
    val node = 6
    val edge = 5

    val nodes = arrayOf(arrayOf(1, 2), arrayOf(2, 5), arrayOf(5, 1), arrayOf(3, 4), arrayOf(4, 6))

    DFS(node = node, edge = edge, arr = nodes).search()
}