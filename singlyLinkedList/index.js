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
        let curr = head || this.head
        if(!curr) {
            console.log("List is Empty :(");
            return -1;
        };
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

    deleteFirst(){
        if(this.head === null){
            console.log("List is Empty :(")
        }else{
            let temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            --this.length;
            return temp.data;
        }
    }

    deleteLast(){
        if(!this.head){
            console.log("List is Empty :(")
        }else if(!this.head.next){
           this.head = this.head.next;
        }else{
            let [curr,prev] = [this.head.next,this.head];
            while(curr.next){
                prev = curr;
                curr = curr.next
            }
            prev.next = null;
            --this.length;
            return curr.data;
        }
    }

    deleteAt(pos){
        if(pos<0 || pos>this.length+1) {
            console.log(`operation fails for Invalid positin ${pos}.\nNote : 0 to ${this.length} positions available`);
            return;
        } 
        else if(!this.head){
            console.log("List is Empty :(")
        }else if(pos ===1){
            this.deleteFirst();
        }else{
            let [prev,count] = [this.head,1];
            while(count < pos-1){
                count++;
                prev = prev.next;
            }
            prev.next = prev.next.next;
            --this.length;
        }
    }

    find(key){
        let curr = this.head;
        while(curr){
            if(curr.data === key) return true;
            curr =  curr.next;
        }
        return false;
    }
    reverse(){
        let [curr,prev,next] = [this.head,null,null];
        while(curr){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    nthNodeFromLast(n){
        let [mainPtr,refPtr,count] = [this.head,this.head,0];
        while(count<n){
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr.data;
    }

    removeDuplicates(head){
        let curr = head || this.head;
        while(curr && curr.next){
            if(curr.data === curr.next.data){
                curr.next = curr.next.next
            }else curr = curr.next;
        }
    }

    insertInSortedList(data){
       let newNode = new Node(data);
       let curr = this.head;
       let temp = null;

       while(curr && curr.data < newNode.data){
          temp = curr;
          curr = curr.next;
       }
       newNode.next = curr;
       temp.next = newNode;
       return ++this.length;
    }

    removeKey(key){
        if(!this.head) return null;
        let curr = this.head;
        let temp = null;
        if(curr && curr.data === key){
            head = curr.next;
            return ;
        }
        while(curr && curr.data!=key){
            temp = curr;
            curr = curr.next;
        }
        if(!curr) return null;
        temp.next = curr.next;
    }

    createLoop(){
        let first = new Node(1);
        let second = new Node(2);
        let third = new Node(3);
        let forth = new Node(4);

        this.head = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = second;
    }

    continesLoop(getStartingNode,removeLoop){
        let fastPtr = this.head;
        let slowPtr = this.head;
        while(fastPtr && fastPtr.next){
           fastPtr = fastPtr.next.next;
           slowPtr = slowPtr.next;
           if(fastPtr === slowPtr) {
             if(getStartingNode) return this.getStartingNode(slowPtr);
             if(removeLoop) return this.removeLoop(slowPtr);
             return true;
           } 
        }
        return false;
    }

    getStartingNode(slowPtr){
        let temp = this.head;
        while(temp!==slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    removeLoop(slowPtr){
        let temp = this.head;
        while(temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return true;
    }

    static merge(l1,l2){
        let dummy = new Node(0);
        let temp = dummy;
        while(l1 && l2){
            if(l1.data<l2.data){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1){
            temp.next = l1
        }else{
            temp.next = l2;
        }
        return dummy.next;
    }

    static add(a,b){
       let dummy = new Node(0);
       let tail = dummy;
       let carry = 0;
       while(a || b){
          let x = a ? a.data : 0;
          let y = b ? b.data : 0;
          let sum = carry + x + y;
          carry = Math.floor(sum / 10);
          tail.next = new Node(sum%10);
          tail = tail.next;
          if(a) a = a.next;
          if(b) b = b.next;
       }
       if(carry>0){
         tail.next = new Node(carry)
       }
       return dummy.next;
    }
}

// const linkedList = new LinkedList();

// linkedList.createLoop();
// console.log(linkedList.continesLoop(0,true));

// linkedList.printList();

const l1 = new LinkedList();
const l2 = new LinkedList();
l1.insertLast(1);
l1.insertLast(3);
l1.insertLast(5);
l2.insertLast(2);
l2.insertLast(4);
l2.insertLast(6);

// l1.printList(LinkedList.merge(l1.head,l2.head));

l1.printList();
l2.printList();

console.log(LinkedList.add(l1.head, l2.head))

l1.printList(LinkedList.add(l1.head, l2.head))


// linkedList.creatingAList()

// linkedList.insertFirst(0)
// linkedList.insertLast(20)
// linkedList.insertLast(10)
// linkedList.printList(linkedList.head);
// linkedList.insertAt(100,25)  //data,pos
// linkedList.insertAt(9,1)
// console.log(linkedList.deleteFirst());
// console.log(linkedList.deleteLast());
// linkedList.printList(linkedList.head);
// linkedList.deleteAt(60)
// linkedList.printList(linkedList.head);
// console.log(linkedList.find(20))
// linkedList.head = linkedList.reverse();
// linkedList.printList(linkedList.head)
// console.log(linkedList.nthNodeFromLast(3))

// linkedList.insertLast(1);
// linkedList.insertLast(1);
// linkedList.insertLast(4);
// linkedList.insertLast(10);
// linkedList.insertLast(10);

// linkedList.printList()

// linkedList.removeDuplicates();

// linkedList.printList(); 

// linkedList.insertInSortedList(2);
// linkedList.insertInSortedList(6);
// linkedList.insertInSortedList(7);

// linkedList.removeKey(2)
// linkedList.removeKey(7)

// linkedList.printList()
