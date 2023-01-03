package algorithm.sort

class InsertSort(arr: MutableList<Int>) {
    private val baseArr = arr

    fun print() {
        for (i in 1 until baseArr.size) {
            var minIdx = i
            for (j in i - 1 downTo 0) {
                if (baseArr[i] < baseArr[j]) {
                    minIdx = j
                } else break
            }
            val removedItem = baseArr.removeAt(i)
            baseArr.add(minIdx, removedItem)
        }

        for (v in baseArr) {
            println(v)
        }
    }
}