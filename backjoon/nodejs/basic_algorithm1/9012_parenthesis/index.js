const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const input = fs.readFileSync("dummy.txt").toString().trim().split("\n");

let left = 0;
let right = 0;
const out = [];

input.shift();

for (val of input) {
  const vals = val.split('');
  let isBiggerThenLeft = false;

  for (v of vals) {
    if (v === '(') {
      left++;
    } else {
      right++;
    }
    if (right > left) {
      isBiggerThenLeft = true;
    }
  }

  if (!isBiggerThenLeft && left === right) {
    out.push('YES');
  } else {
    out.push('NO');
  }
  
  left = 0;
  right = 0;
}

console.log(out.join('\n'))