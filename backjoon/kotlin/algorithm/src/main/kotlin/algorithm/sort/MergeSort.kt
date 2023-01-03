package algorithm.sort

class MergeSort(arr: MutableList<Int>) {
    private val baseArr = arr
    private val tempArr = IntArray(arr.size)

    private fun sort(s: Int, e: Int) {
        if ((e - s) < 1) return

        val mid = s + (e - s) / 2

        sort(s, mid)
        sort(mid + 1, e)

        // bottom-up, 후위 연산
        for (i in s..e) {
            tempArr[i] = baseArr[i]
        }

        // two pointer move
        var k = s // 결과 배열 인덱스
        var s1 = s // 1번째 배열 인덱스
        var s2 = mid + 1 // 2번째 배열 인덱스

        while (s1 <= mid && s2 <= e) {
            if (tempArr[s1] < tempArr[s2]) {
                baseArr[k] = tempArr[s1]
                s1++
            } else {
                baseArr[k] = tempArr[s2]
                s2++
            }
            k++
        }

        // 한쪽 배열 모두 삽입 후 남은 값 삽입 로직
        while (s1 <= mid) {
            baseArr[k] = tempArr[s1]
            s1++
            k++
        }
        while (s2 <= e) {
            baseArr[k] = tempArr[s2]
            s2++
            k++
        }
    }

    fun print() {
        sort(0, baseArr.size - 1)
        for (v in baseArr) {
            println(v)
        }
    }
}