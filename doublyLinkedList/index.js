class Node{
    constructor(data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList{
    constructor(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    isEmpty(){
        return this.length === 0;
    }

    displayForward(){
        let temp = this.head;
        let str = '';
        while(temp){
            str += `${temp.data} --> `
            temp = temp.next;
        }
        str += 'null';
        console.log(str);
    }

    displayBackward(){
        let temp = this.tail;
        let str = '';
        while(temp){
            str += `${temp.data} --> `
            temp = temp.prev;
        }
        str += 'null';
        console.log(str);
    }

    insertFirst(data){
       let newNode = new Node(data);

       if(this.isEmpty()){
        this.tail = newNode
       }else{
         this.head.prev = newNode;
       }
        newNode.next = this.head;
        this.head = newNode;
        return ++this.length;
    }

    insertLast(data){
       let newNode = new Node(data);
       if(this.isEmpty()) this.head = newNode
       else this.tail.next = newNode
       newNode.prev = this.tail;
       this.tail = newNode
       return ++this.length;
    }

    deleteFirst(){
        if(this.isEmpty()) return console.log("List is Empty")
        let temp = this.head;
        if(this.head === this.tail) this.tail = null;
        else this.head.next.prev = null;
        this.head = this.head.next;
        temp.next = null;
        return --this.length;
    }

    deleteLast(){
        if(this.isEmpty()) return console.log("List is Empty");

        let temp = this.tail;
        if(this.head === this.tail) this.head = null;
        else this.tail.prev.next = null;
        this.tail = this.tail.prev;
        temp.prev = null;
        return --this.length;
    }
}


const dl = new DoublyLinkedList();

// console.log(dl)

dl.insertFirst(1)
dl.insertFirst(2)
dl.insertFirst(3)

dl.insertLast(0);
dl.insertLast(-1);
dl.insertLast(-2);
dl.displayForward();
// dl.displayBackward();

dl.deleteFirst();
dl.displayForward();
console.log(dl.length)