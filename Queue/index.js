class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class Queue{
    constructor(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    isEmpty(){
        return this.length === 0;
    }

    size(){
        return this.length;
    }

    display(){
       if(this.isEmpty()) return console.log("List is Empty :(");
       let temp = this.front;
       let str = `[${this.length}] `;
       while(temp !== null){
           str+=`${temp.data} --> `
           temp = temp.next;
       }
       console.log(str+"null");
       return this.length;
    }

    enQueue(data){
        let newNode = new Node(data);
        if(this.isEmpty()) this.front = newNode;
        else this.rear.next = newNode;
        this.rear = newNode;
        return ++this.length;
    }

    deQueue(){
        if(this.isEmpty()) return console.log("List is Empty :(");
        let temp = this.front;
        this.front = this.front.next;
        if(this.front === null){
            this.rear = null;
        }
        temp.next = null;
        --this.length;
        return temp.data;
    }

    first(){
        if(this.isEmpty()) return console.log("List is Empty :(");
        return this.front.data;
    }

    last(){
        if(this.isEmpty()) return console.log("List is Empty :(");
        return this.rear.data;
    }
}

const queue = new Queue();

queue.enQueue(1);
queue.enQueue(2);
queue.enQueue(3);
queue.enQueue(4);

console.log(queue.deQueue());

console.log(queue.first());
console.log(queue.last());
queue.deQueue()
queue.display()

console.log(generateBinary(10))

function generateBinary(n){
    const queue = new Queue();
    queue.enQueue("1");
    let result =[];
    for(let i=0;i<n;i++){
        result[i] = queue.deQueue();
        queue.enQueue(result[i] + "0");
        queue.enQueue(result[i] + "1");
    }
    return result;
}