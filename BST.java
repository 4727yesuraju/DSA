class BST{
    Node root;
    class Node{
        int data;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    BST(){
        this.root = null;
    }

    void insert(int data){
        this.root = insert(this.root,data);
    }
    Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data<root.data){
            root.left = insert(root.left,data);
        }else{
            root.right = insert(root.right,data);
        }
        return root;
    }

    void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    Node search(Node root,int key){
        if(root == null || key == root.data) return root;
        if(key<root.data) return search(root.left,key);
        else return search(root.right,key);
    }

    boolean isValid(Node root, int min, int max){
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        boolean left = isValid(root.left,min,root.data);
        if(left){
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String args[]){
           BST bst = new BST();
           bst.insert(1);
           bst.insert(3);
           bst.insert(4);
           bst.insert(5);
           bst.insert(2);
           bst.inOrder(bst.root);
           System.out.println();
           Node res = bst.search(bst.root,20);
           if(res != null){
            System.out.println(res.data);
           }
           System.out.println(bst.isValid(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}