package algorithm.sort

class BubbleSort(arr: Array<Int>) {
    private val baseArr: Array<Int> = arr

    fun print() {
        for (i in 0 until baseArr.size - 1) {
            for (j in 0 until baseArr.size - 1 - i) {
                if (baseArr[j] > baseArr[j + 1]) {
                    // swap
                    baseArr[j] = baseArr[j + 1].also { baseArr[j + 1] = baseArr[j] }
                }
            }
        }

        for (v in baseArr) {
            println(v)
        }
    }
}