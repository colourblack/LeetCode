package list.num141;

import list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 使用快慢指针，可以解决大多链表有关位置和长度的问题
 * 难点在于，如何避免null的出现，以及即使的结束循环！
 */
public class LinkedListHasCircle {

    /** 把每一个访问过的节点放入set中 */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hasVisited = new HashSet<>();
        while (true) {
            if (hasVisited.contains(head)){
                return true;
            }
            if (head == null ||head.next == null){
                return false;
            }
            hasVisited.add(head);
            head = head.next;
        }
    }

    public boolean hasCycleNext(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        /*
         * 当len>=2时,设列表总长度为 len,
         * 设列表总长度为 len，快节点的行走速度是慢节点的2倍，
         * 当慢节点走到第n个节点时
         * 若是循环列表，则必有 2n mod len = n.
         */
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
