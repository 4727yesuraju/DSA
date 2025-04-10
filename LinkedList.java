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
            System.out.print(curr.data+" --> ");
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

    Node deleteFirst(){
        if(head == null) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    Node deleteLast(){
        if(head == null || head.next == null){
            head = null;
            return null;
        }
        Node prev = null;
        Node curr = head;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }

    void deleteAt(int pos){
       if(pos == 1){
          head = head.next;
       }else{
         Node prev = head;
         int count = 1;
         while(count<pos-1){
            prev = prev.next;
         }
         prev.next = prev.next.next;
       }
    }


    boolean search(int key){
        Node curr = head;
        while(curr!=null){
            if(curr.data == key) return true;
            curr = curr.next;
        }
        return false;
    }

    Node reverse(){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node nthNodeFromLast(int n){
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        while(count < n){
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr!=null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    void removeDuplicatesFromSortedList(){
        Node curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.data == curr.next.data) curr.next = curr.next.next;
            else curr = curr.next;
        }
    }

    void insertInsortedList(int data){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.data < data){
           prev = curr;
           curr = curr.next;
        }
        Node newNode = new Node(data);
        newNode.next = curr;
        prev.next = newNode;
    }

    void removeKey(int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.data != key){
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) return;
        prev.next = curr.next;
    }

    void createLoop(){
        Node first = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head = first;
        first.next = sec;
        sec.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sec;
    }

    boolean containesLoop(){
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr) return true;
        }
        return false;
    }

    Node returnStartingNode(Node slowPtr){
        Node temp = head;
        while(temp!=slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }
    Node getStartingNode(){
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return returnStartingNode(slowPtr);
        }
        return null;
    }

    void removeLoop(Node slowPtr){
       Node temp = head;
       while(temp.next != slowPtr.next){
           temp = temp.next;
           slowPtr = slowPtr.next;
       }
       slowPtr.next = null;
    }
    void removeLoop(){
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr) removeLoop(slowPtr);
        }
    }


    Node merge(Node a,Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(a!=null && b!=null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a==null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }

    Node addList(Node a,Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        while(a!=null || b!=null){
            int x = a!=null ? a.data : 0 ;
            int y = b!=null ? b.data : 0 ;
            int sum = carry + x + y ;
            carry = sum /10;
            tail.next = new Node(sum%10);
            tail = tail.next;
            if(a!=null) a= a.next;
            if(b!=null) b = b.next;
        }

        if(carry > 0) tail.next = new Node(carry);
        return dummy.next;
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

        // ll.insertFirst(4);
        // ll.insertFirst(4);
        // ll.insertFirst(2);
        // ll.insertFirst(1);

        // ll.insertAt(3, 3);
        // ll.print(ll.head);
        // ll.deleteFirst();
        // ll.print(ll.head);
        // ll.deleteLast();
        // ll.print(ll.head);
        // ll.deleteAt(2);
        // ll.print(ll.head);
        // System.out.println(ll.search(30));
        // ll.reverse();
        // ll.print(ll.reverse());
        // System.out.println(ll.nthNodeFromLast(2).data);
        // ll.removeDuplicatesFromSortedList();
        // ll.print(ll.head);
        // ll.insertInsortedList(30);
        // ll.print(ll.head);

        // ll.removeKey(30);
        // ll.print(ll.head);

        // ll.createLoop();
        // ll.print(ll.head);
        // System.out.println(ll.containesLoop());
        // System.out.println(ll.getStartingNode().data);
        // ll.removeLoop();
        // System.out.println(ll.containesLoop());

        LinkedList ll1 = new LinkedList();
        ll1.insertLast(1);
        ll1.insertLast(3);
        ll1.insertLast(5);

        LinkedList ll2 = new LinkedList();
        ll2.insertLast(2);
        ll2.insertLast(4);
        ll2.insertLast(6);

        // ll1.print(ll1.merge(ll1.head,ll2.head));
        ll1.print(ll1.head);
        ll1.print(ll2.head);


        ll1.print(ll1.addList(ll1.head, ll2.head));




    }
}