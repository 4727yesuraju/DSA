// class CircularQueue {
//   constructor(capacity) {
//     this.items = new Array(capacity);
//     this.front = -1;
//     this.rear = -1;
//     this.capacity = capacity;
//     this.currentLength = 0;
//   }
//   isFull() {
//     return this.capacity === this.currentLength;
//   }
//   isEmpty() {
//     return this.currentLength === 0;
//   }

//   enQueue(ele) {
//     if (!this.isFull()) {
//       this.rear = (this.rear + 1) % this.capacity;
//       this.items[this.rear] = ele;
//       this.currentLength++;
//       if (this.front === -1) this.front = this.rear;
//       return;
//     }
//     console.log("Queue is full");
//     return;
//   }

//   deQueue() {
//     if (this.isEmpty()) return null;
//     let ele = this.items[this.front];
//     this.front = (this.front + 1) % this.capacity;
//     this.currentLength--;
//     if (this.isEmpty()) {
//       this.front = -1;
//       this.rear = -1;
//     }
//     return ele;
//   }

//   peek() {
//     if (this.isEmpty()) {
//       console.log("Queue is empty");
//       return null;
//     }
//     return this.items[this.front];
//   }

//   print() {
//     if (this.isEmpty()) {
//       console.log("Queue is Empty");
//       return;
//     }
//     let i,
//       str = "";
//     for (i = this.front; i != this.rear; i = (i + 1) % this.capacity) {
//       str += this.items[i] + " ";
//     }
//     str += this.items[i];
//     console.log(str);
//   }
// }
// const queue = new CircularQueue(4);
// console.log(queue.isEmpty());
// console.log(queue.isFull());
// queue.print();
// queue.enQueue(10);
// queue.enQueue(20);
// queue.enQueue(10);
// queue.enQueue(20);
// queue.enQueue(10);
// queue.enQueue(20);
// // queue.deQueue();
// queue.deQueue();

// console.log(queue.peek());
// queue.print();

class CircularQueue {
  constructor(capacity = 5) {
    this.items = new Array(capacity);
    this.front = -1;
    this.rear = -1;
    this.capacity = capacity;
    this.size = 0;
  }

  isEmpty() {
    return this.size === 0;
  }
  isFull() {
    return this.size === this.capacity;
  }
  peek() {
    if (this.isEmpty()) {
      console.log("Queue is Empty");
    } else {
      return this.items[this.front];
    }
  }
  enQueue(ele) {
    if (this.isFull()) {
      console.log("Queue is full");
    } else {
      this.rear = (this.rear + 1) % this.capacity;
      this.items[this.rear] = ele;
      this.size++;
      if (this.front === -1) this.front = this.rear;
    }
  }
  deQueue() {
    if (this.isEmpty()) {
      console.log("Queue is Empty");
    } else {
      let ele = this.items[this.front];
      this.items[this.front] = null;
      this.front = (this.front + 1) % this.capacity;
      this.size--;
      if (this.isEmpty()) {
        this.front = -1;
        this.rear = -1;
      }
      return ele;
    }
  }

  print() {
    if (this.isEmpty()) {
      console.log("Queue is Empty");
    } else {
      let i,
        str = "<-- ";
      for (i = this.front; i != this.rear; i = (i + 1) % this.capacity) {
        str += this.items[i] + ", ";
      }
      str += this.items[i] + " <-- ";
      return str;
    }
  }
}

const queue = new CircularQueue(5);
queue.enQueue(1);
queue.enQueue(10);
queue.enQueue(11);
queue.enQueue(13);
queue.enQueue(15);
// queue.enQueue(1);
console.log(queue.deQueue());
console.log(queue.print());
console.log(queue);
