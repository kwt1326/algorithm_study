/**
 * https://www.acmicpc.net/problem/17298
 * 
 * 가까운 값 찾기위해 stack 사용합니다.
 * 
 * for 로 풀면 시간초과 합니다. O(n^2)
 * 
 * stack 에 아직 오큰수를 찾지 못한 인덱스를 쌓아놓고,
 * while 문에서 한번에 비교를 때린다.
 * 그렇게 함으로써 루프를 조회하는 횟수를 줄입니다.
 * 
 * ex) 같은 nums[i] 가 오큰수인 인덱스 1,2 while 한번에 찾아집니다.
 * [ 0, 1, 2 ][ -1, -1, 8, -1 ] 3  // find, stack pop
 * [ 0, 1 ][ -1, 8, 8, -1 ] 3      // find, stack pop
 * [ 0, 3 ] // not found, stack push
 * [ -1, 8, 8, -1 ] // OUTPUT
 */

const fs = require('fs');
// const [_n, num] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [_n, num] = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const n = parseInt(_n);
const nums = num.split(' ').map(_ => parseInt(_));

const out = Array(n).fill(-1);
const stack = [];

for (let i = 0; i < n; ++i) {
  while (
    stack.length > 0 &&
    nums[stack[stack.length - 1]] < nums[i]
  ) {
    out[stack.pop()] = nums[i]
    console.log(out, i)
  }

  stack.push(i);
  console.log(stack)
}

console.log(out.join(' '))