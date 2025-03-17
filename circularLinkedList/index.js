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
        if(!last) return console.log('list is Empty')
        let temp = this.last.next;
        let str = "";
        while(temp !== this.last){
            str += `${temp.data} --> `;
            temp = temp.next;
        }
        str += `${temp.data} --> null`
        console.log(str);
    }
}

const cll = new circulaLinkedList();
cll.createCircularLinkedList();
cll.display();