/**
 * 후기 :
 * 문제 처음 봤을때 문제 이해가 잘 안됐다..
 */

const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const input = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const out = [];
const stack = [];

const n = input.shift();
let j = 0;

for (let i = 1; i <= n; ++i) {
  stack.push(i);
  out.push('+');
  while (stack[stack.length - 1] === parseInt(input[j])) {
    stack.pop();
    out.push('-');
    j++;
  }
}

console.log(j !== parseInt(n) ? 'NO' : out.join('\n'));