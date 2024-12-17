public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int length;

    private class Node{
        private int data;
        private Node prev;
        private Node next;

        public  Node(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length==0;//head==null
    }

    public int length(){
        return length;
    }

    public void displayForward(){  //temp.next
        if(head==null) return;

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println(" null ");

    }
    public void displayBackward(){ //temp.prev
        if(tail==null) return;

        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.prev;
        }
        System.out.println(" null ");

    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()) tail = newNode;
        else head.prev = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }
    public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);

        dll.displayForward();
        dll.displayBackward();
    }
}