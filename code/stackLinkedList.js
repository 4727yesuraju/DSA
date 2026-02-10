const { LinkedList } = require("./LinkedListWithTail");

class Stack {
  constructor() {
    this.list = new LinkedList();
  }

  push(val) {
    this.list.prepend(val);
  }
  pop() {
    return this.list.removeFromFront();
  }
  peek() {
    return this.list.head.value;
  }
  isEmpty() {
    return this.list.isEmpty();
  }
  getSize() {
    return this.list.getSize();
  }
  print() {
    this.list.print();
  }
}

const stack = new Stack();

console.log("-->isEmpty", stack.isEmpty());
console.log("-->size", stack.getSize());

stack.push(1);
stack.push(2);
stack.push(3);

stack.print();
console.log(stack.pop());

console.log(stack.peek());

stack.print();
console.log("-->isEmpty", stack.isEmpty());
console.log("-->size", stack.getSize());

console.log("-->End");
