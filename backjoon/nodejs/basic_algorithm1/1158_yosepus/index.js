/**
 * https://www.acmicpc.net/problem/1158
 * 
 * 조세푸스 수열
 * 큐를 사용해서 풀면 쉬운 문제라고 합니다.
 * 큐의 front 를 다시 push 하는 식으로 큐를 돌리고,
 * 제거할 대상을 제거 합니다. 그리고 다시 N 만큼 반복
 * O(N * K), 즉 시간 복잡도 N
 * 
 * 문제 주의 사항
 * <,> 이 패턴을 꼭 넣어 줘야 합니다. (안그러면 실패 뜸)
 * 
 */

const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
// const input = fs.readFileSync("dummy.txt").toString().trim().split(" ");
let n = parseInt(input[0]), _k = parseInt(input[1]);

const out = []
const q = [...Array(n + 1).keys()];

q.shift();

while (q.length !== 0) {
  let cnt = 0;
  while (_k - 1 > cnt) {
    q.push(q.shift())
    cnt++;
  }

  out.push(q.shift());
}

console.log(`<${out.join(', ')}>`)
