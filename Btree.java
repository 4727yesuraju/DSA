
import java.util.Stack;

class Btree{
    Node root;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }

    void createBtree(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        this.root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    void preOrder(Node root){
        if(root == null) return ;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void preOrderLoop(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.data+ " ");
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        
    }

    void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void main(String args[]){
          Btree  bt = new Btree();
          bt.createBtree();
          bt.preOrder(bt.root);
          System.out.println();
          bt.preOrderLoop(bt.root);
          System.out.println();
          bt.inOrder(bt.root);
    }
}