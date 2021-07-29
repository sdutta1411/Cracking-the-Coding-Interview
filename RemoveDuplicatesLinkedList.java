/*
Write code to remove duplicates from an unsorted linked list.
 */

import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicatesLinkedList {

    public class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //Given an unsorted LinkedList we have to remove the duplicates nodes
    public static void deleteDuplicates(Node n) {

        //Approach 1: Using HashSet. Add the node.data to HashSet, if it already contains the node.data, remove it from
        //List by prev.next=curr.next O(N) Time Complexity, N: number of elements in Linked List

        Set<Integer> set = new HashSet<Integer>();
        Node prev = null, curr = n;

        while (curr != null) {
            //If HashSet has the data remove the node
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                //Add the node.data to HashSet if it is not there
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

    }

}
