class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  isEmpty() {
    return this.size === 0;
  }

  getSize() {
    return this.size;
  }

  prepend(value) {
    const newNode = new Node(value);
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.size++;
  }

  append(value) {
    const node = new Node(value);
    if (this.isEmpty()) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  removeFromFront() {
    if (this.isEmpty()) return null;
    const value = this.head.value;
    if (this.size === 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.next;
    }
    this.size--;
    return value;
  }

  removeFromEnd() {
    if (this.isEmpty()) return;
    const value = this.tail.value;
    if (this.size === 1) {
      this.head = null;
      this.tail = null;
    } else {
      let prev = this.head;
      while (prev.next !== this.tail) {
        prev = prev.next;
      }
      prev.next = null;
      this.tail = prev;
    }
    this.size--;
    return value;
  }
  print() {
    if (this.isEmpty()) return null;
    let curr = this.head;
    let str = "";
    while (curr) {
      str += curr.value + " ";
      curr = curr.next;
    }
    console.log(str);
  }
}

module.exports = { LinkedList };
// const ll = new LinkedList();

// console.log("-->isListEmpty", ll.isEmpty());

// ll.append(1);
// ll.append(2);
// ll.append(3);
// ll.prepend(0);
// ll.prepend(-1);
// ll.prepend(-2);

// // console.log(ll);
// console.log("-->isListEmpty", ll.isEmpty());
// ll.print();

// ll.removeFromFront();
// ll.removeFromEnd();

// ll.print();

// console.log("End");
