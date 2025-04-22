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
        if(root.data<data){
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

    public static void main(String args[]){
           BST bst = new BST();
           bst.insert(1);
           bst.insert(3);
           bst.insert(4);
           bst.insert(5);
           bst.insert(2);


           bst.inOrder(bst.root);
    }
}