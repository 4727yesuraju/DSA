
import java.util.Arrays;
import java.util.EmptyStackException;

class StackDemo{
    Node top;
    int length;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    StackDemo(){
        this.top = null;
        this.length = 0;
    }
     
    boolean isEmpty(){
        return this.length == 0;
    }

    int size(){
        return this.length;
    }

    int push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        return ++this.length;
    }

    int pop(){
        if(isEmpty()) throw new EmptyStackException();
        Node temp = top;
        top = top.next;
        temp.next = null;
        return --this.length;
    }
    int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return this.top.data;
    }

    void display(){
        Node temp = top;
        System.out.print("top --> ");
        while(temp!=null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println(" null ");
    }

    static int[] nextGreateElement(int[] arr){
        int[] res = new int[arr.length];
        StackDemo stack = new StackDemo();
        for(int i = arr.length-1;i>-1;i--){
            while(!stack.isEmpty() && stack.peek() < arr[i]) stack.pop();
            if(stack.isEmpty())  res[i] = -1;
            else res[i] = stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }


    public static void main(String args[]){
         StackDemo stack = new StackDemo();
         stack.push(1);
         stack.push(2);
         stack.push(3);
        //  stack.pop();
        //  stack.display();
         System.out.println(Arrays.toString(nextGreateElement(new int[]{4,7,3,4,8,1})));
    }
}