import java.util.*

fun swap(arr: MutableList<Int>, s: Int, e: Int) {
    // pivot with first swap
    arr[s] = arr[e].also { arr[e] = arr[s] }
}

// Get Pivot
fun partition(arr: MutableList<Int>, s: Int, e: Int): Int {
    if (s + 1 == e) {
        if (arr[s] > arr[e]) {
            swap(arr, s, e)
        }
        return e
    }

    // 정렬 최적화를 위해 중간지점을 pivot 으로 삼는다.
    val mid = (s + e) / 2

    // pivot with first swap
    swap(arr, s, mid)

    // [pivot, i, ..., j]
    val pivot = arr[s]
    var i = s + 1
    var j = e

    while (i <= j) {
        // until pivot lower then
        // pivot 보다 작은 arr[j] 가 나올 때까지 좌측으로 쭉 이동합니다.
        while (pivot < arr[j] && j > 0) {
            j--
        }
        // until pivot bigger then
        // pivot 보다 큰 arr[i] 가 나올 때까지 우측으로 쭉 이동합니다.
        while (pivot > arr[i] && i < arr.size - 1) {
            i++
        }

        // pivot 보다 각각 크고(arr[i]) 작은(arr[j]) 가 나왔으므로 서로 swap 한다. (정렬)
        // swap 시 바로 다음 index 로 넘어가기 위해 ++, -- 연산 수행
        if (i <= j) {
            swap(arr, i++, j--)
        }
    }

    arr[s] = arr[j]
    arr[j] = pivot
    return j
}

fun quickSort(arr: MutableList<Int>, s: Int, e: Int, k: Int) {
    if (s < e) {
        val pivot = partition(arr, s, e)
        if (pivot == k) return
        else if (k < pivot) {
            quickSort(arr, s, pivot - 1, k)
        } else {
            quickSort(arr, pivot + 1, e, k)
        }
    }
}

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val k = nextInt()
    val baseArr = mutableListOf<Int>()

    for (i in 1..n) {
        baseArr.add(nextInt())
    }

    quickSort(baseArr, 0, baseArr.size - 1, k - 1)
    println(baseArr[k - 1])
}

// 추신. 뭔가 시간초과가 계속 뜨는데,
// 직접 구현으로는 '우선순위 큐'나 '내장 정렬 함수'를 이용해서 날먹 하는게 아니면
// 백준 시스템에서 맞추긴 힘들것 같아 그냥 이렇게 구현할 수 있구나~~ 하고 넘어가기!