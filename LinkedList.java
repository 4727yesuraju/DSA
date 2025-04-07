public class LinkedList{
    private Node head;
    private static class Node{
         private Node next;
         private int data;
         public Node(int data){
            this.data = data;
            this.next = null;
         }
    }

    void print(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+"-->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    int length(){
         int size = 0;
         Node curr = this.head;
         while(curr != null){
            size++;
            curr = curr.next;
         }
         return size;
    }

    void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertLast(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            return;
        }

        Node curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    void insertAt(int data, int pos){
        Node newNode = new Node(data);
        if(pos == 1){
            newNode.next = head;
            head = newNode;
        }else{
            Node prev = head;
            int count = 1;
            while(count<pos-1){
                prev = prev.next;
                count++;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // Node second = new Node(2);
        // Node third = new Node(3);
        // Node fourth = new Node(4);

        // ll.head.next = second;
        // second.next = third;
        // third.next = fourth;
        // ll.print(ll.head);

        // System.out.println(ll.length());

        ll.insertFirst(4);
        ll.insertFirst(2);
        ll.insertFirst(1);

        ll.insertAt(3, 3);
        ll.print(ll.head);


    }
}