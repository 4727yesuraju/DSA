class HashTable {
  constructor(size) {
    this.table = new Array(size);
    this.size = size;
  }
  hash(key) {
    let total = 0;
    for (let i = 0; i < key.length; i++) {
      total += key.charCodeAt(i);
    }
    return total % this.size;
  }
  set(key, value) {
    const index = this.hash(key);
    // this.table[index] = value;
    //to avoid collisions
    const bucket = this.table[index];
    if (!bucket) {
      this.table[index] = [[key, value]];
    } else {
      const sameKeyItem = bucket.find((item) => item[0] === key);
      if (sameKeyItem) {
        sameKeyItem[0] = value;
      }
      bucket.push([key, value]);
    }
  }
  get(key) {
    const index = this.hash(key);
    // return this.table[index];
    const bucket = this.table[index];
    if (bucket) {
      const sameKeyItem = bucket.find((item) => item[0] === key);
      return sameKeyItem[1];
    }
    return undefined;
  }
  remove(key) {
    const index = this.hash(key);
    // if (this.table[index]) this.table[index] = undefined;
    const bucket = this.table[index];
    if (bucket) {
      const keyIndex = bucket.findIndex((item) => item[0] === key);
      console.log("-->keyIndex", keyIndex);
      if (keyIndex != -1) bucket.splice(keyIndex, 1);
    }
  }
  display() {
    for (let i = 0; i < this.size; i++) {
      if (this.table[i]) console.log(i, this.table[i]);
    }
  }
}

const table = new HashTable(40);

table.set("name", "yesu");
table.set("mane", "raju");

table.set("age", 25);

console.log(table.get("name"));
console.log(table.get("age"));
table.remove("mane");

table.display();

console.log("-->end");
