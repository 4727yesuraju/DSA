
import java.util.Queue;
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

    void inOrderLoop(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }

    void postOrderLoop(Node root){
       Node curr = root;
       Stack<Node> stack = new Stack<>();

       while(curr!=null || !stack.isEmpty()){
         if(curr!=null){
            stack.push(curr);
            curr = curr.left;
         }else{
           Node temp = stack.peek().right;
           if(temp == null){
                temp = stack.pop();
                System.out.print(temp.data+" ");
                while(!stack.isEmpty() && temp == stack.peek().right){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                }
           }else{
                curr = temp;
           }
         }
       }
    }   

    void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null) queue.offer(temp.left);
            if(temp.right!=null) queue.offer(temp.right);
        
        }
    }

    int findMax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int res = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > res) res = left;
        if(right > res) res = right;
        return res;
    }
    public static void main(String args[]){
          Btree  bt = new Btree();
          bt.createBtree();
        //   bt.preOrder(bt.root);
        //   System.out.println();
        //   bt.preOrderLoop(bt.root);
        //   System.out.println();
        //   bt.inOrder(bt.root);
        //   System.out.println();
        //   bt.inOrderLoop(bt.root);

        // bt.postOrder(bt.root);
        // System.out.println();
        // bt.postOrderLoop(bt.root);

        bt.levelOrder(bt.root);
        System.out.println("\nMax value : "+bt.findMax(bt.root));
    }
}