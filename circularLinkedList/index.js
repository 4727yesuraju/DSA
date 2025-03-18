class Node{
    constructor(data){
        this.data = data
    }
}
class circulaLinkedList{
    constructor(){
        this.length = null;
        this.last = null;
    }

    isEmpty(){
        return !this.length;
    }
     
    size(){
        return this.length
    }

    createCircularLinkedList(){
        let first = new Node(1);
        let second = new Node(2);
        let third = new Node(3);
        let fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        
        this.last = fourth;
    }

    display(){
        if(!this.last) return console.log('list is Empty')
        let temp = this.last.next;
        let str = "";
        while(temp !== this.last){
            str += `${temp.data} --> `;
            temp = temp.next;
        }
        str += `${temp.data} --> null`
        console.log(str);
    }

    insertFirst(data){
        let newNode = new Node(data);
        if(!this.last) this.last = newNode;
        else newNode.next = this.last.next;
        this.last.next = newNode
        return ++this.length;
    }

    insertLast(data){
        let newNode = new Node(data);
        if(!this.last) {
            this.last = newNode;
            this.last.next = newNode;
        }else{
            newNode.next = this.last.next;
            this.last.next = newNode;
            this.last = newNode
        }
        return ++this.length;
    }

    deleteFirst(){
        if(this.isEmpty()) return console.log("List is Empty");
        let temp = this.last.next;
        if(this.last.next === this.last) this.last = null;
        else this.last.next = temp.next;
        temp.next = null;
        --this.length;
        return temp;
        
    }
}

const cll = new circulaLinkedList();
// cll.createCircularLinkedList();

cll.insertFirst(1);
cll.insertFirst(2);
cll.insertFirst(3);
cll.insertFirst(4);

cll.insertLast(5);
cll.insertLast(6);
cll.insertLast(7);
cll.insertLast(8);


console.log(cll.deleteFirst());
cll.deleteFirst();
cll.deleteFirst();
cll.deleteFirst();
cll.display();