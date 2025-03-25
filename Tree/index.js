class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}



class Tree{
    constructor(){
        this.root = null;
    }

    createTree(){
        let first = new Node(1);
        let second = new Node(2);
        let third = new Node(3);
        let fourth = new Node(4);
        let fifth = new Node(5);

        this.root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    preOrder(root){
        if(!root) return null;
        process.stdout.write(`${root.data}  `);
        this.preOrder(root.left);
        this.preOrder(root.right);
    }
}


const tree = new Tree();

tree.createTree();
tree.preOrder(tree.root)
