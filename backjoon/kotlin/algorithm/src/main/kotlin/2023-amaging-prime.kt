import java.util.*

// v / 2 까지의 수로 나눈 나머지가 모두 존재하면 소수
fun isPrime(v: Int): Boolean {
    for (i in 2..v/2)
        if (v % i == 0)
            return false

    return true
}

fun dfs(v: Int, dep: Int) {
    if (dep == v.toString().length) {
        println(v)
        return
    }
    for (i in 1..9 step 2) {
        val value = v * 10 + i
        if (isPrime(value)) {
            dfs(value, dep)
        }
    }
}

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    dfs(2, n)
    dfs(3, n)
    dfs(5, n)
    dfs(7, n)
}