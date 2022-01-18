/**
 * https://www.acmicpc.net/problem/10845
 * 
 */

const fs = require('fs');
 const [n, ...arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const [n, ...arr] = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const out = []
const q = [];

for (c of arr) {
  const [cmd, val] = c.split(' ')
  switch (cmd) {
    case 'push':
      q.push(val);
      break;
    case 'pop':
      if (q.length === 0) {
        out.push(-1);
        continue;
      }
      out.push(q.shift());
      break;
    case 'front':
      if (q.length === 0) {
        out.push(-1);
        continue;
      }
      out.push(q[0]);
      break;
    case 'back':
      if (q.length === 0) {
        out.push(-1);
        continue;
      }
      out.push(q[q.length - 1]);
      break;
    case 'size':
      out.push(q.length);
      break;
    case 'empty':
      out.push(q.length === 0 ? 1 : 0);
      break;
    default:
      break;
  }
}

console.log(out.join('\n'))
 