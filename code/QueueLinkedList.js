const { LinkedList } = require("./LinkedListWithTail");

class QueueLinkedList {
  constructor() {
    this.list = new LinkedList();
  }
  enqueue(value) {
    this.list.append(value);
  }
  dequeue() {
    return this.list.removeFromFront();
  }
  peek() {
    return this.list.head.value;
  }
  isEmpty() {
    return this.list.isEmpty();
  }
  size() {
    return this.list.getSize();
  }
  print() {
    this.list.print();
  }
}

const queue = new QueueLinkedList();
console.log("-->isEmpty", queue.isEmpty());
console.log("-->getSize", queue.size());

queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);

queue.print();

console.log("-->isEmpty", queue.isEmpty());
console.log("-->getSize", queue.size());

console.log("-->end");
