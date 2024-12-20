public class SingleLinkedList{
    private ListNode head; //instance variable

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void createDemo(SingleLinkedList obj){
         obj.head = new ListNode(10);
         ListNode second = new ListNode(20);
         ListNode third = new ListNode(30);

         //connecting nodes
         head.next = second; //10 --> 20
         second.next = third; // 10 ---> 20 --> 30

    }

    static void display(ListNode head){
        ListNode curr = head;
        //System.out.print("head --> ");
        while(curr != null){
            System.out.print(curr.data+" --> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    int length(){
        if(head==null) return 0;
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }

    void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    void insertEnd(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    void insert(int value,int pos){ //1 --> 2 --> 3
        ListNode newNode = new ListNode(value);
        if(pos == 1){
           newNode.next = head;
           head = newNode;
           return;
        }
        ListNode prev = head;
        int count = 1;
        while(count<pos-1){
            prev = prev.next;
            count++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    ListNode deleteFirst(){
        if(head==null) return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    ListNode deleteLast(){
        if(head==null || head.next==null){
            head = null;
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next!=null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }

    void delete(int pos){
        if(pos==1){
            head = head.next;
        }else{
            ListNode prev = head;
            int count = 1;
            while(count < pos-1){
                prev = prev.next;
                count++;
            }
            prev.next = prev.next.next;
        }
    }

    boolean searchData(int data){
        ListNode curr = head;
        while(curr!=null){
            if(curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    ListNode reverse(){
        ListNode prev = null,next = null, curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    ListNode getNthNodeFromEnd(int n){
        if(head == null) return null;
        if(n<=0) throw new IllegalArgumentException("Invalid value n = "+n);
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count<n){
            if(refPtr==null) throw new IllegalArgumentException(n+" is greated then no.of nodes in the list");
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    void removeDuplicate(){
        if(head == null) return ;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data) curr.next = curr.next.next;
            else curr = curr.next;
        }
    }
    void insertInSortedList(int data){
       ListNode newNode = new ListNode(data);
       if(head == null) {
        head = newNode;
        return;
       }
       if(head.data>=data){
          newNode.next = head;
          head = newNode;
          return;
       }else{
        ListNode curr = head;
        ListNode temp = null;
        while(curr!=null && curr.data<data){
            temp = curr;
            curr = curr.next;
        }
        newNode.next = curr;
        temp.next = newNode;
       }
    }

    void removeKey(int key){
        if(head!=null && head.data == key){
            head = head.next;
            return;
        }
        ListNode curr = head;
        ListNode temp = null;
        while(curr!=null && curr.data!=key){
            temp = curr;
            curr = curr.next;
        }
        if(curr==null) return;
        temp.next = curr.next;
    }
    void createLoop(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        fifth.next = second;
    }
    boolean containsLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                
                return true;
            }
        }
        return false;
     }
    ListNode containsLoopAndReturnFirst(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return returnFirst(slowPtr);
            }
        }
        return null;
     }

     ListNode returnFirst(ListNode slowPtr){
        ListNode temp = head;
        while(temp!=slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
     }

    void removeLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                removeLoop(slowPtr);
            }
        }
     }

     void removeLoop(ListNode slowPtr){
        ListNode temp = head;
        while(slowPtr.next!=temp.next){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
     }

     static ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
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
        if(a!=null) tail.next = a;
        else tail.next = b;
        return dummy.next;
     }

     static ListNode add(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a!= null || b!=null){
            int x = a!=null ? a.data : 0;
            int y = b!=null ? b.data : 0;
            int sum = x+y+carry;
            carry = sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            if(a!=null) a= a.next;
            if(b!=null) b=b.next;
        }

        if(carry >0)  tail.next = new ListNode(carry);

        return dummy.next;
     }
    public static void main(String args[]){
         SingleLinkedList sll1 = new SingleLinkedList();
         SingleLinkedList sll2 = new SingleLinkedList();

         sll1.insertEnd(7);
         sll1.insertEnd(4);
         sll1.insertEnd(9);
         sll2.insertEnd(5);
          sll2.insertEnd(6);
        //  sll2.insertEnd(2);
        //  sll2.insertEnd(3);

         ListNode temp = add(sll1.head,sll2.head);
         display(temp);
        //  sll1.insertEnd(1);
        //  sll1.insertEnd(3);
        //  sll1.insertEnd(5);
        //  sll1.insertEnd(7);
        //  sll2.insertEnd(2);
        //  sll2.insertEnd(4);
        //  sll2.insertEnd(6);
        //  sll2.insertEnd(8);
        //  sll2.insertEnd(10);
        //  sll2.insertEnd(12);
        //  display(sll1.head);
        //  display(sll2.head);
        // ListNode temp = merge(sll1.head, sll2.head);
        // display(temp);
        //sll.display();
        //  sll.createLoop();
        //  if(sll.containsLoop()) System.out.println("contains loop");
        //  else System.out.println("no loop");

        //  System.out.println(sll.containsLoopAndReturnFirst().data);
        //  sll.removeLoop();
        // if(sll.containsLoop()) System.out.println("contains loop");
        // else System.out.println("no loop");

        // sll.insertEnd(1);
        // sll.insertEnd(2);
        // sll.insertEnd(2);
        // sll.insertEnd(3);
        // sll.insertEnd(3);
        // sll.display();
        // sll.removeDuplicate();
        // sll.display();
        // sll.insertInSortedList(5);
        // sll.insertInSortedList(0);
        // sll.display();
        // sll.removeKey(5);
        // sll.display();
        // sll.createDemo(sll);
        //System.out.println(sll.getNthNodeFromEnd(1).data);
        // sll.delete(2);
        // sll.display();
        // sll.head = sll.reverse();
        // sll.display();

        //System.out.print(sll.searchData(1));
        //System.out.println(sll.length());
    }
}