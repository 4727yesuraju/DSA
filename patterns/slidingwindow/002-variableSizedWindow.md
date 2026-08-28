# 🔄 Variable-Size Window — Sliding Window

## 1. 📖 Simple English Explanation

**Variable-Size Window** is a Sliding Window technique used when the size of the subarray/substring can **change**.

We use two pointers:

* `left` → start of the window
* `right` → end of the window

Move `right` to **expand** the window.
Move `left` to **shrink** the window when the window becomes invalid.

### Basic idea

```text
    Array:
    [2, 1, 5, 1, 3, 2]

        left
            ↓
    [2, 1, 5]
            ↑
        right

    Window size can change:
    [2]
    [2,1]
    [2,1,5]
    [1,5]
    [5]
...
```

---

## 2. 🤔 Why is it Needed?

Suppose the question asks:

> Find the **longest subarray** whose sum is `≤ 7`.

Checking every possible subarray takes **O(n²)**.

Sliding Window can solve many such problems in **O(n)**.

Instead of creating a new subarray every time:

```text
Expand → Check condition → Shrink if needed → Update answer
```

---

## 3. 🌊 Flow

The most important pattern is:

```text
left = 0

for right = 0 → n-1

    add arr[right] to window

    while window is invalid
        remove arr[left]
        left++

    update answer
```

### Remember:

```text
right → EXPAND 🚀
left  → SHRINK 📉
```

---

## 4. ✍️ Syntax

### General Template

```js
    let left = 0;
    let answer = 0;
    let windowValue = 0;

    for (let right = 0; right < arr.length; right++) {

        // 1. Expand window
        windowValue += arr[right];

        // 2. Shrink window if invalid
        while (windowValue > condition) {
            windowValue -= arr[left];
            left++;
        }

        // 3. Update answer
        answer = Math.max(answer, right - left + 1);
    }
```

### Window Size

```js
right - left + 1
```

This is very important.

---

## 5. 💻 Example

### Problem

> Find the **longest subarray** whose sum is `≤ 7`.

```js
const arr = [2, 1, 5, 1, 3, 2];

let left = 0;
let sum = 0;
let maxLength = 0;

for (let right = 0; right < arr.length; right++) {

    // Expand
    sum += arr[right];

    // Shrink
    while (sum > 7) {
        sum -= arr[left];
        left++;
    }

    // Update answer
    maxLength = Math.max(maxLength, right - left + 1);
}

console.log(maxLength); // 4
```

### Let's understand the movement

```text
arr = [2, 1, 5, 1, 3, 2]

right = 0
[2]
sum = 2
length = 1

right = 1
[2, 1]
sum = 3
length = 2

right = 2
[2, 1, 5]
sum = 8 ❌

Shrink:
remove 2

[1, 5]
sum = 6 ✅
length = 2

right = 3
[1, 5, 1]
sum = 7 ✅
length = 3

right = 4
[1, 5, 1, 3]
sum = 10 ❌

Shrink:
remove 1 → sum = 9
remove 5 → sum = 4

[1, 3]
sum = 4 ✅
```

The window keeps changing size.

That's why it is called:

**Variable-Size Window**.

---


## 7. 🧠 Memory Trick

Remember:

```text
    RIGHT → EXPAND
    LEFT  → SHRINK

    Expand → Check → Shrink → Update
```

Or simply:

```text
    🚀 RIGHT = Grow
    📉 LEFT  = Reduce
```

### Most important formula

```js
    window size = right - left + 1
```

---

## 8. ⭐ Keywords

```text
    Variable-Size Sliding Window
    Two Pointers
    left
    right
    Expand
    Shrink
    while loop
    Window Size
    right - left + 1
    Longest Subarray
    Shortest Subarray
    Substring
    O(n)
```

### 📝 Pattern to memorize

```js
    let left = 0;

    for (let right = 0; right < arr.length; right++) {

        // Expand

        while (/* invalid */) {
            // Shrink
            left++;
        }

        // Update answer
    }
```

**One-line idea:**

> **Expand with `right`, shrink with `left`, update the answer after the window becomes valid.**
