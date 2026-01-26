function bubbleSort(arr) {
  let swapped;
  do {
    swapped = false;
    for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        arr[i] += arr[i + 1];
        arr[i + 1] = arr[i] - arr[i + 1];
        arr[i] -= arr[i + 1];
        swapped = true;
      }
      console.log("-->", i, arr);
    }
  } while (swapped);
}

function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let numberToInsert = arr[i];
    let j = i - 1;
    while (j > -1 && arr[j] > numberToInsert) {
      arr[j + 1] = arr[j--];
    }
    arr[j + 1] = numberToInsert;
  }
}

function quickSort(arr) {
  if (arr.length < 1) return arr;
  let left = [],
    right = [],
    pivot = arr[arr.length - 1];
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] < pivot) left.push(arr[i]);
    else right.push(arr[i]);
  }
  return [...quickSort(left), pivot, ...quickSort(right)];
}

function mergeSort(arr) {
  console.log("-->", arr);
  if (arr.length < 2) return arr;

  let mid = Math.floor(arr.length / 2);
  const leftArr = arr.slice(0, mid);
  const rightArr = arr.slice(mid);

  return merge(mergeSort(leftArr), mergeSort(rightArr));
}

function merge(leftArr, rightArr) {
  console.log("-->lr", { leftArr, rightArr });
  let tempArr = [];
  while (leftArr.length && rightArr.length) {
    if (leftArr[0] < rightArr[0]) tempArr.push(leftArr.shift());
    else tempArr.push(rightArr.shift());
  }
  console.log("-->re", [...tempArr, ...leftArr, ...rightArr]);
  return [...tempArr, ...leftArr, ...rightArr];
}

const arr = [3, 2, 4, 1, 0, -1];

// bubbleSort(arr);
// insertionSort(arr);
console.log(mergeSort(arr));
console.log(quickSort(arr));

// console.log(arr);
