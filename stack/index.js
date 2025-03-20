class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}


class Stack{
    constructor(){
        this.top = null;
        this.length = 0;
    }

    size(){
        return this.length;
    }

    isEmpty(){
        return this.length === 0
    }

    peek(){
        if(this.isEmpty()) return console.log("Stack is Empty");
        return this.top.data
    }

    pop(){
        if(this.isEmpty()) return console.log("List is Empty")
        let res = this.top;
        this.top = this.top.next;
        --this.length;
        res.next = null;
        return res.data;
    }

    push(data){
       let newNode = new Node(data);
       newNode.next = this.top;
       this.top = newNode;
       return ++this.length;
    }
}

let stack = new Stack();

// console.log(reverseAString("yesu"))
// console.log(nextGreaterElement([1,2,3,4,5,6]))
console.log(isValidParathsis("()()"))
// console.log(stack);

function reverseAString(str){
    let stack = new Stack();
    for(let i=0;i<str.length;i++){
        stack.push(str[i]);
    }

    let res = ""
    for(let i=0;i<str.length;i++){
        res += stack.pop()
    }
    return res;
}


function nextGreaterElement(arr){
    let stack = new Stack();
    let res = [];
    for(let i=arr.length-1;i>=0;i--){
        while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
        if(stack.isEmpty()) res[i] = -1;
        else res[i] = stack.peek();
        stack.push(arr[i]);
    }
    return res
}


function isValidParathsis(str){
    let stack = new Stack();
    for(let c of str){
        if(c === '(' || c === '{' || c === '[') stack.push(c)
        else {
          if(stack.isEmpty()) return false;
          else{
            let top = stack.peek();
            if( (top === '[' && c === ']') || 
                (top === '{' && c === '}') || 
                (top === '(' && c === ')') 
              )  stack.pop();
            else return false;
          }
        }
    }
    return stack.isEmpty();
}