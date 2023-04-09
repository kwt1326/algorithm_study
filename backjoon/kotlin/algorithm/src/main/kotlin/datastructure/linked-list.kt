package datastructure

class Node<T>(
    val value: T?
) {
    var next: Node<T>? = null
}

class LinkedList<T>(
    private var head: Node<T>? = null,
    private var tail: Node<T>? = null
) {
    // same push_back
    fun append(node: Node<T>) {
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
    }

    fun get(index: Int): Node<T>? {
        if (head == null) return null

        var cur: Node<T>? = head!!
        var count = 0
        while (cur != null) {
            if (count != index) {
                cur = cur.next
                count++
            } else {
                return cur
            }
        }

        return null
    }

    fun insertAt(index: Int, node: Node<T>): Boolean {
        if (head == null) return false

        var cur: Node<T>? = head!!
        // 이전 노드를 알고 있어야 삽입할 노드의 [이전 <- 현재 -> 다음] 을 연결할 수 있다.
        var prev: Node<T>? = cur
        var count = 0

        while (cur != null) {
            if (count != index) { // 위치 도달할 때까지 순회
                prev = cur
                cur = cur.next
                count++
            } else { // 위치 도달시 이전 - 현재 - 다음 연결
                prev?.next = node
                node.next = cur
                return true
            }
        }

        return false
    }

    fun removeAt(index: Int): Boolean {
        if (head == null) return false

        var cur: Node<T>? = head!!
        var prev: Node<T>? = cur
        var count = 0

        while (cur != null) {
            if (count != index) {
                prev = cur
                cur = cur.next
                count++
            } else { // GC가 미참조 메모리 릴리스 하므로 cur.next 로 바로 이전 노드 연결
                prev?.next = cur.next
                return true
            }
        }

        return false
    }

    fun printAll() {
        if (head == null) return

        var cur: Node<T>? = head!!
        while (cur != null) {
            println(cur.value)
            cur = cur.next
        }
    }
}

fun main() {
    val list = LinkedList<Int>()

    list.append(Node(1))
    list.append(Node(2))
    list.append(Node(3))
    list.insertAt(2, Node(9))
    list.removeAt(1)

    list.printAll()

    println("GET: ${list.get(1)?.value}")
}