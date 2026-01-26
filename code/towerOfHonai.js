function towerOfHonai(n, fromRod, toRod, usingRod) {
  if (n === 1) {
    console.log(`move desk 1 from ${fromRod} to ${toRod}`);
    return;
  }
  towerOfHonai(n - 1, fromRod, usingRod, toRod);
  console.log(`move desk ${n} from ${fromRod} to ${toRod}`);
  towerOfHonai(n - 1, usingRod, toRod, fromRod);
}

towerOfHonai(2, "A", "C", "B");
