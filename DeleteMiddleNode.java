    /*
    Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the
    exact middle) of a singly linked list, given only access to that node.
     */
    public class DeleteMiddleNode {

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

        public boolean deleteMiddleNode(Node n){

            if(n == null || n.next ==null)
                return false;

            //Assign n.next.data to n.data and n.next.next to n.next and thus deleting node n
            n.data = n.next.data;
            n.next = n.next.next;

            return true;
        }

        public static void main(String[] args) {

        }
    }
