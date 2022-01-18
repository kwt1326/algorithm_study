/**
 * https://www.acmicpc.net/problem/1406
 * 
 * 실패 요인 :
 * splice 함수를 사용하면 시간 초과로 실패한다.
 * 
 * 해결 :
 * 속도가 빠른 stack 자료구조를 사용하여 분할하여 원래 글자의 배열로
 * 커서 위치를 계산하고, 마지막에 합침 으로써 연산을 최대한으로 줄인다.
 * (이 때, stack 은 반드시 다시 뒤집어 합쳐야 제대로 합쳐진다. push_back 으로 인해 뒤집어 지기 때문)
 */

const fs = require('fs');
const [str, _, ...arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const [str, _, ...arr] = fs.readFileSync("dummy.txt").toString().trim().split("\n");

let strs = str.split('');
let stack = [];

for (v of arr) {
  const [command, value] = v.split(' ');
  switch (command) {
    case 'P':
      strs.push(value);
      break;
    case 'B':
      if (strs.length > 0) strs.pop();
      break;
    case 'L':
      if (strs.length === 0) continue;
      stack.push(strs.pop());
      break;
    case 'D':
      if (stack.length === 0) continue;
      strs.push(stack.pop());
      break;
    default:
      break;
  }
}

console.log(strs.concat(stack.reverse()).join(''));