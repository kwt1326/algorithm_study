package algorithm.sort

class QuickSort(arr: MutableList<Int>) {
    private val baseArr = arr

    private fun recursive(pivot: Int, arr: MutableList<Int>): List<Int> {
        if (arr.size <= 1) return arr

        val lowers = mutableListOf<Int>()
        val bigger = mutableListOf<Int>()
        var left = listOf<Int>()
        var right = listOf<Int>()

        for (v in arr) {
            if (pivot < v) {
                bigger.add(v)
            }
            if (pivot > v) {
                lowers.add(v)
            }
        }

        if (lowers.size > 0) {
            left = recursive(lowers[lowers.size - 1], lowers)
        }
        if (bigger.size > 0) {
            right = recursive(bigger[bigger.size - 1], bigger)
        }
        return left.plus(pivot).plus(right)
    }

    fun print() {
        val result = recursive(baseArr[baseArr.size - 1], baseArr)
        for (v in result) {
            println(v)
        }
    }

    private fun swap(arr: MutableList<Int>, s: Int, e: Int) {
        // pivot with first swap
        arr[s] = arr[e].also { arr[e] = arr[s] }
    }

    private fun quickSort(arr: MutableList<Int>, s: Int, e: Int) {
        val mid = (s + e) / 2
        val pivot = arr[mid]
        var i = s
        var j = e

        while (i <= j) {
            while (arr[i] < pivot) i++ // until arr[i] >= pivot
            while (arr[j] > pivot) j-- // until arr[j] <= pivot

            // 큰 값과 작은 값의 순서를 맞춰준다.
            if (i <= j) swap(arr, i++, j--)
        }

        if (s < j) {
            quickSort(arr, s, j)
        }
        if (i < e) {
            quickSort(arr, i, e)
        }
    }

    fun print2() {
        quickSort(baseArr, 0, baseArr.size - 1)

        for (v in baseArr) {
            println(v)
        }
    }
}