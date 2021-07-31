import java.util.HashSet;

/*
Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 */
public class LinkedListLoopDetection {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Approach 1: Using HashSet, add the nodes to HashSet, if there is loop there will be error in addition to Set
    //Not an optimized approach, Runtime: 3ms, and extra space: O(n)
    public ListNode loopDetection1(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode curr = head;
        HashSet<ListNode> list = new HashSet<ListNode>();

        while (curr.next != null) {
            if (list.contains(curr)) return curr;

            list.add(curr);
            curr = curr.next;
        }

        return null;

    }

    //Approach 2: Using 2 pointer approach, fast and slow pointer. 1st detect the loop by moving fast pointer 2 times
    //faster than slow. Then they meet at k steps from start of loop. Move slow to head and keep fast where they meet
    // and then they meet at beginning of loop. Runtime: 1ms, space: O(1)
    public ListNode loopDetection2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;

        //Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //Collision
            if (slow == fast) {
                break;
            }
        }

        //Error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        //Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
        //Loop Start. If they move at the same pace, they must meet at Loop Start.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* Both now point to the start of the loop. */
        return fast;

    }

    public static void main(String[] args) {

    }

}
