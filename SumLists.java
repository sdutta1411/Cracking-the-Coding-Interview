/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and
returns the sum as a linked list.
 */
public class SumLists {

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

    //This method works fine if numbers are reversed in the lists
    public ListNode sumLists(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1, ptr2 = l2, curr = null;

        //Creating a dummy head node
        ListNode newHead = new ListNode();
        curr = newHead;

        int carry = 0;

        //Looping till either l1 or l2 becomes null
        while (ptr1 != null && ptr2 != null) {
            carry += ptr1.val + ptr2.val;
            if (carry < 9) {
                ptr1.val = carry;
                curr.next = ptr1;
                curr = curr.next;
                carry = 0;
            } else {
                ptr1.val = carry % 10;
                curr.next = ptr1;
                curr = curr.next;
                carry /= 10;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        //If nodes are remaining in l1
        while (ptr1 != null) {
            carry += ptr1.val;
            if (carry < 9) {
                ptr1.val = carry;
                curr.next = ptr1;
                curr = curr.next;
                carry = 0;
            } else {
                ptr1.val = carry % 10;
                curr.next = ptr1;
                curr = curr.next;
                carry /= 10;
            }

            ptr1 = ptr1.next;
        }

        //If nodes are remaining in l2
        while (ptr2 != null) {
            carry += ptr2.val;
            if (carry < 9) {
                ptr2.val = carry;
                curr.next = ptr2;
                curr = curr.next;
                carry = 0;
            } else {
                ptr2.val = carry % 10;
                curr.next = ptr2;
                curr = curr.next;
                carry /= 10;
            }

            ptr2 = ptr2.next;
        }

        //If carry is not 0
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
