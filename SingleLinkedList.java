public class SingleLinkedList{
    private ListNode head;

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

    void display(){
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
    public static void main(String args[]){
         SingleLinkedList sll = new SingleLinkedList();
        // sll.createDemo(sll);
        sll.insertEnd(1);
        sll.insertEnd(2);
        sll.insertEnd(3);
        sll.insertEnd(4);
        sll.insert(10,5);
         sll.display();
         System.out.println(sll.length());
    }
}