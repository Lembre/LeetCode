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
        int num1 = 342;
        int num2 = 465;

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
        ListNode tmp = l1;
        while (l1 != null) {
           if (l1.val + l2.val >= 10) {
               if (l1.next == null) {
                   l1.next = new ListNode(1);
               } else {
                   l1.next.val++;
               }
           }
           l1.val = (l1.val + l2.val) % 10;
           l1 = l1.next;
           l2 = l2.next;
        }
        return tmp;
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