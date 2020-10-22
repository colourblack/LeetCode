package another.num445;


import java.util.Stack;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);
        Stack<Integer> s3 = new Stack<>();

        int temp = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            temp = s1.pop() + s2.pop() + temp;
            if (temp > 9) {
                s3.push(temp % 10);
                temp = 1;
            } else {
                s3.push(temp);
                temp = 0;
            }
        }

        if (s1.isEmpty() && s2.isEmpty()) {

        } else if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                temp = temp + s2.pop();
                if (temp > 9) {
                    s3.push(temp % 10);
                    temp = 1;
                } else {
                    s3.push(temp);
                    temp = 0;
                }
            }
        } else if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                temp = temp + s1.pop();
                if (temp > 9) {
                    s3.push(temp % 10);
                    temp = 1;
                } else {
                    s3.push(temp);
                    temp = 0;
                }
            }
        }

        if (temp == 1) {
            s3.push(temp);
        }

        ListNode result = new ListNode(s3.pop());
        ListNode listNode = result;
        while (!s3.isEmpty()) {
            ListNode ls = new ListNode(s3.pop());
            listNode.next = ls;
            listNode = listNode.next;
        }
        return result;
    }

    private Stack getStack(ListNode ls) {
        Stack<Integer> stack = new Stack<>();
        while (ls != null) {
            stack.push(ls.val);
            ls = ls.next;
        }

        return stack;
    }





    /**
     * 这种解法必须保证数字不会超过整型范围
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode listNode;
        int num1 = getNum(l1);
        int num2 = getNum(l2);
        int sum = num1 + num2;

        Stack<Integer> stack = new Stack<>();
        if (sum > 0) {
            while(sum != 0) {
                stack.push(sum % 10);
                sum = sum / 10;
            }
            result = new ListNode(stack.pop());
            listNode = result;
            while (!stack.isEmpty()) {
                ListNode node = new ListNode(stack.pop());
                listNode.next = node;
                listNode = listNode.next;
            }

            return result;
        } else {
            result = new ListNode(0);
            return result;
        }

    }

    private int getNum(ListNode ls) {
        Stack<Integer> stack= new Stack<>();
        while (ls != null) {
            stack.push(ls.val);
            ls = ls.next;
        }

        int i = 1;
        int num = 0;
        while (!stack.isEmpty()) {
            num = stack.pop() * i + num;
            i = i * 10;
        }
        return num;
    }
}
