
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo{
    Node front;
    Node rear;
    int length;

    class Node{
        int data ;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    QueueDemo(){
      this.front = null;
      this.rear = null;
      this.length = 0;
    }

    boolean isEmpty(){
        return this.length == 0;
    }

    int size(){
        return this.length;
    }

    int enQueue(int data){
       Node newNode = new Node(data);
       if(this.isEmpty()) front = newNode;
       else rear.next = newNode;
       rear = newNode;
       return ++this.length;
    }

    int deQueue(){
        if(isEmpty()) throw new NoSuchElementException("Queue is already Empty");
        Node result = this.front;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        result.next = null;
        --this.length;
        return result.data;
    }

    void display(){
       System.out.print(" front --> ");
       Node temp = this.front;
       while(temp != null){
        System.out.print(temp.data + " --> ");
        temp = temp.next;
       }
       System.out.println("null");
    }

    static String[] generateBinary(int n){
        String[] res = new String[n];
        Queue<String> queue = new java.util.LinkedList<>();
        queue.offer("1");
        for(int i=0; i<n; i++){
            res[i] = queue.poll();
            String n1 = res[i] + "0";
            String n2 = res[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return res;
    }


    public static void main(String args[]){
        QueueDemo queue = new QueueDemo();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.display();

        queue.deQueue();
        queue.deQueue();
        // queue.deQueue();
        // queue.deQueue();

        queue.display();
        System.out.println(Arrays.toString(generateBinary(5)));
    }
}