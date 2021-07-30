/*
Implement a function to check if a linked list is a palindrome.
 */

import java.util.Stack;

public class PalindromeLinkedList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Approach 1: Push the 1st half of the nodes onto a stack and then pop and compare with the 2nd half
    //This is not much optimized. Runtime is slower 7 ms space O(n)
    public boolean isPalindrome1(ListNode head) {

        //Assign slow and fast pointer to head
        ListNode slow = head, fast = head;

        Stack<Integer> stack = new Stack<Integer>();

        //Push elements from first half of linked list onto stack. When fast reaches the end, slow will be in middle
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        //Has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        //Now pop the elements and compare the values
        while (slow != null) {
            int top = stack.pop().intValue();

            //If values are different, then it's not a palindrome
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    //Approach 2: Reverse the 1st half of the list and then compare with the 2nd half.
    //More optimized and lesser runtime with 4 ms, space O(1)
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;

        //While fast reaches end, slow will be in middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }

        //Reverse the slow list and point fast to head
        slow = reverseList(slow);
        fast = head;

        //Compare the values
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {

    }
}
