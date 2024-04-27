package ko.me;

import java.util.Arrays;
import java.util.PriorityQueue;

// 우선순위 큐 문제
// http://letcode.com/problems/merge-k-sorted-lists/
public class _23_merge_k_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.stream(lists).toList().forEach(node -> {
            do {
                if (node == null) break;
                pq.add(node.val);
                node = node.next;
            } while (node != null);
        });

        if (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll());
            ListNode nodenext = node;
            while (!pq.isEmpty()) {
                nodenext.next = new ListNode(pq.poll());
                nodenext = nodenext.next;
            }
            return node;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        mergeKLists(list); // 1, 1, 2, 3, 4, 4, 5, 6
    }
}
