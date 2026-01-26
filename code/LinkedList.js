class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }
  isEmpty() {
    return this.size === 0;
  }
  getSize() {
    return this.size;
  }
  prePend(value) {
    const node = new Node(value);
    if (!this.isEmpty()) {
      node.next = this.head;
    }
    this.head = node;
    this.size++;
  }
  append(value) {
    const newNode = new Node(value);
    if (this.isEmpty()) {
      this.head = newNode;
    } else {
      let prev = this.head;
      while (prev.next) {
        prev = prev.next;
      }
      prev.next = newNode;
    }
    this.size++;
  }
  insert(value, index) {
    if (index < 0 || index > this.size) {
      console.log("Invalid index");
      return;
    }
    if (index === 0) this.append(value);
    else {
      const node = new Node(value);
      let prev = this.head;
      for (let i = 0; i < index - 1; i++) {
        prev = prev.next;
      }
      node.next = prev.next;
      prev.next = node;
      this.size++;
    }
  }
  removeFrom(index) {
    if (index < 0 || index > this.size) return;
    let removedNode;
    if (index === 0) {
      removedNode = this.head;
      this.head = this.head.next;
    } else {
      let prev = this.head;
      for (let i = 0; i < index - 1; i++) {
        prev = prev.next;
      }
      removedNode = prev.next;
      prev.next = removedNode.next;
    }
    this.size--;
    return removedNode.value;
  }

  removeValue(value) {
    if (this.isEmpty()) return null;
    if (this.head.value === value) {
      console.log("-->came1");
      this.head = this.head.next;
      this.size--;
      return value;
    } else {
      console.log("-->came2");
      let prev = this.head;
      while (prev.next && prev.next.value !== value) prev = prev.next;
      if (prev.next) {
        let removedNode = prev.next;
        prev.next = removedNode.next;
        this.size--;
        return value;
      }
      return null;
    }
  }
  search(value) {
    if (this.isEmpty()) return -1;
    let curr = this.head,
      i = 0;
    while (curr) {
      if (curr.value === value) return i;
      curr = curr.next;
      i++;
    }
    return -1;
  }
  print() {
    let curr = this.head;
    let string = "";
    while (curr) {
      string += curr.value + " ";
      curr = curr.next;
    }
    console.log(string);
  }
}



const ll = new LinkedList();
console.log(ll.isEmpty());
console.log(ll.getSize());
ll.print();
ll.prePend(1);
ll.prePend(10);
ll.prePend(100);
ll.append(1);
ll.append(10);
ll.append(100);
console.log(ll.isEmpty());
console.log(ll.getSize());

ll.insert(2, 2);
// ll.removeFrom(2);
// ll.removeFrom(1);
// ll.removeFrom(0);

// ll.removeValue(1);
// ll.removeValue(1);
// ll.removeValue(100);
// ll.removeValue(10);
console.log("-->serch", ll.search(1));
ll.print();

// console.log(ll);
