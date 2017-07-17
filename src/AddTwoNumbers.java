/**
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        int num1 = 346;
        int num2 = 86;

        ListNode l1 = new AddTwoNumbers().proListNode(num1);
        ListNode l2 = new AddTwoNumbers().proListNode(num2);
        ListNode l3 = new AddTwoNumbers().reverseListNode(l1);
        ListNode l4 = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.print(l4.val);
        while (l4.next != null) {
            System.out.print(" -> ");
            System.out.print(l4.next.val);

            l4 = l4.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0), cur = dummyNode;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummyNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode proListNode(int num) {
        ListNode l1 = new ListNode(0);
        ListNode tmp = l1;
        while (num > 1) {
            int n = num % 10;
            num = num / 10;
            l1.next = new ListNode(n);
            l1 = l1.next;
        }

        return tmp.next;
    }

    // 翻转二叉树
    private ListNode reverseListNode(ListNode l) {
        ListNode tmp1 = new ListNode(l.val);
        ListNode tmp2 = tmp1;
        while (l.next != null) {
            tmp1 = new ListNode(l.next.val);
            tmp1.next = tmp2;
            tmp2 = tmp1;
            l = l.next;
        }
        return tmp2;
    }

}