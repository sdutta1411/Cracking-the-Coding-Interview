    /*
    Implement an algorithm to find the kth to last element of a singly linked list.
     */
    public class ReturnKthToLast {
        //Given a linked list and we need to return the kth element from last

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

        //Approach1: Find out the length of the list and in next pass iterate to the length-k element and return it.
        //Very trivial solution, may be interviewer is not expecting this. Time Complexity: O(N)

        public static int printKthToLast1(Node head, int k) {
            Node curr = head;
            int len=0;

            //Find out the length of the list
            while(curr != null){
                len++;
                curr = curr.next;
            }

            curr = head;
            //Iterate through the list till len-k
            for(int i=0; i<=len-k; i++){
                curr = curr.next;
            }
            //Return the curr.data
            return curr.data;
        }

        /*Approach2: Using two pointer approach
        Assign two pointers p1 and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and
        moving p1 k nodes into the list. Then, when we move them at the same pace, p1 will hit the end of the linked list
        after LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
         */

        public static int printKthToLast2(Node head, int k) {
            Node p1 = head;
            Node p2 = head;

            //Moving p1 k nodes into the list.
             for (int i= 0; i < k; i++) {
              if (p1 == null) return -1;
               p1 = p1.next;
               }

             //Move them at the same pace. When pl hits the end, p2 will be at the right element.
             while (p1!= null) {
                 p1 = p1.next;
                 p2 = p2.next;
                 }
             return p2.data;
        }

        public static void main(String[] args) {

        }
    }
