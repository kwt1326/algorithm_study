import java.util.*

fun main() {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  
  val queue = ArrayDeque<Int>(n)
  
  queue.addAll(1..n)

  while (queue.size > 1) {
    queue.removeFirst()
    queue.addLast(queue.removeFirst())
  }

  println(queue.removeFirst())
}