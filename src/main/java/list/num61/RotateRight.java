package list.num61;

import list.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Fangjunjin
 * @since 2021/3/27
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode preHead = new ListNode();
        preHead.next = head;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        // newHead.next 指向移动后的新链表头
        newHead.next = head;
        while (head.next != null) {
            head = head.next;
        }
        node = preHead.next;
        for (int i = 0; i < k; i++) {
            head.next = node;
            node = node.next;
            head = head.next;
        }

        head = null;
        return newHead.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 7; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        RotateRight r = new RotateRight();
        r.rotateRight(head, 11);

    }
}
