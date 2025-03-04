class Node{
    constructor(data=null){
        this.data = data;
        this.next = null;
    }
}


class LinkedList{
    constructor(){
        this.head = null;
        this.length = 0;
    }
    creatingAList(){
        this.head = new Node(1);
        let first = new Node(2);
        let second = new Node(3);
        let third = new Node(4);

        this.head.next = first;
        first.next = second;
        second.next = third;
        this.length = 4;
    }

    printList(head){
        let str = !head ? `[${this.length}] ` : "";
        if(!head) console.log("List is Empty :(");
        let curr = head || this.head;
        let size = 0;
        while(curr){
            str += curr.data+" --> ";
            curr = curr.next;
            size += 1;
        }
        if(head) str = `[${size}] ` + str;
        console.log(str+"null");
    }

    //optional
    size(){
        let [count,curr] = [0,this.head]
        while(curr){
            count+=1;
            curr = curr.next;
        }
        return count;
    }

    insertFirst(data){
       let newNode = new Node(data);
       newNode.next = this.head;
       this.head = newNode;
       return ++this.length;
    }

    insertLast(data){
        let newNode = new Node(data);
        if(!this.head)  {
            this.head = newNode
            return ++this.length
        }
        let curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        return ++this.length;
    }

    insertAt(data,pos=1){
        if(pos<0 || pos>this.length+1) {
            console.log(`operation fails for Invalid positin ${pos}.\nNote : 0 to ${this.length+1} positions only`);
            return;
        }
       if(pos === 1) return this.insertFirst(data);
       let newNode = new Node(data)
       let prev = this.head;
       let count = 1;
       while(count < pos-1 /* && prev.next */){ //insert at last
        //   if(!prev.next) prev.next = new Node(0) //insert all fields with 0 till 19
        //   if(!prev.next) throw new Error("Invalid range")
          prev = prev.next;
          count++;
       }
       newNode.next = prev.next;
       prev.next = newNode;

    }
}

const linkedList = new LinkedList();

linkedList.creatingAList()

linkedList.insertFirst(0)
linkedList.insertLast(20)
linkedList.insertLast(10)
linkedList.printList(linkedList.head);
linkedList.insertAt(100,25)  //data,pos
linkedList.insertAt(9,1)
linkedList.printList(linkedList.head);


