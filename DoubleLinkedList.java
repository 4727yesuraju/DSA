
class DoubleLinkedList{
    Node head;
    Node tail;
    int length;
    private class Node{
        Node prev;
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    boolean isEmpty(){
        return this.length == 0;
    }

    int size(){
        return length;
    }

    void insertLast(int data){
        Node newNode = new Node(data);
        if(tail == null) head = newNode;
        else tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        this.length++;
    }

    void insertFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()) tail = newNode;
        else head.prev = newNode;
        newNode.next = head;
        head = newNode;
        this.length++;
    }

    void displayForward(){
        if(head == null) return;
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayBackward(){
        if(tail == null) return;
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insertLast(2);
        dl.insertLast(1);
        dl.displayForward();
        dl.displayBackward();
    }
}