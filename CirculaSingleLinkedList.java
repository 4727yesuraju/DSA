
import java.util.NoSuchElementException;

class CircularSingleLinkedList{
    public Node last;
    public int length;

    public class Node{
        int data;
        Node next;
        Node( int data){
            this.data = data;
        }
    }

    CircularSingleLinkedList(){
        last = null;
        length = 0;
    }

    boolean isEmpty(){
        return this.length == 0;
    }

    int size(){
        return this.size();
    }

    void createList(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    void display(){
        if(last == null) return;
        Node first = last.next;
        while(first!=last){
            System.out.print(first.data+" --> ");
            first = first.next;
        }
        System.out.println(last.data+" --> null");
    }

    void insertFirst(int data){
        Node temp = new Node(data);
        if(last == null) last = temp;
        else temp.next = last.next;
        last.next = temp;
        this.length++;
    }

    void insertLast(int data){
        Node temp = new Node(data);
        if(last == null){
            last = temp;
            last.next = last;
        }else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    Node deleteFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        Node temp = last.next ;
        if(last.next == last) last = null;
        else last.next = temp.next;
        --this.length;
        return temp;

    }

    public static void main(String[] args) {
        CircularSingleLinkedList cl = new CircularSingleLinkedList();
        cl.createList();
        cl.insertFirst(0);
        cl.insertFirst(-1);
        cl.insertLast(5);
        cl.display();
        cl.deleteFirst();
        cl.display();
    }
}