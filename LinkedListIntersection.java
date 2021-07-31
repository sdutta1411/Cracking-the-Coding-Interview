import java.util.HashSet;
import java.util.Set;

/*
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact
same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class LinkedListIntersection {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Approach 1: Using HashSet, 1st add all nodes of headA to HashSet and then check if any node is same in the headB
    //Not an efficient approach, took lot of time to execute.
    //Time: O(n+m), Space: O(n+m), n=length of headA, m=length of headB

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode n1=headA,n2=headB;

        Set<ListNode> hs = new HashSet<ListNode>();
        //Adding all nodes of headA
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        //Check if node of headB exist or else add to hashSet
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }

    //Approach 2: Brute force technique, highly inefficient, takes Time: O(n*m), space: O(1)
    //Start looping 1st list and check each and every node in 2nd list
    //Runtime is worst 831 ms

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode currA = headA;

        while (currA != null){
            ListNode currB = headB;
            while (currB != null){
                if (currA == currB){
                    return currA;
                }else{
                    currB = currB.next;
                }
            }
            currA = currA.next;
        }
        return null;

    }


    //Approach 3: An efficient approach using 2 pointer technique. Start iterating the lists, if end of one is
    // encountered move the pointer to start of next. The loop ends, if both are not intersecting
    // Time: O(N + M), Space : O(1). 1 ms, very less time consuming

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (ptrA != ptrB) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;

    }

    public static void main(String[] args) {

    }
}
