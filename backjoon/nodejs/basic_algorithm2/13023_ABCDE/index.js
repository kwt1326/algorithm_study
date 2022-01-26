/**
 * https://www.acmicpc.net/problem/13023
 * 
 * DFS & 인접행렬로 해결 가능 문제
 * 문제 지문 이해힘듬;;;
 * 
 * 친구관계 깊이 4 이면 true
 * 
 * 인접 리스트로 줄였음에도 불구하고 제출 실패함
 */
const fs = require('fs');
// const [input, ...arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [input, ...arr] = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const [n, m] = input.split(' ').map(v => +v);
let visit = Array(n).fill(0)
let adjArr = Array.from({ length: n }, () => Array(0))
let result = 0;

// 인접 행렬 초기화 (시간 초과, 실패)
// for (let i=0; i < m; ++i) {
//   const [a, b] = arr[i].split(' ').map(v => +v);
//   adjArr[a][b] = adjArr[b][a] = 1;
// }

// 인접 리스트 초기화
for (let i = 1; i < m; ++i) {
  const [a, b] = arr[i].split(' ').map(v => +v);
  adjArr[a].push(b);
  adjArr[b].push(a);
}

function dfs(i, dep) {
  if (result === 1) return;
  visit[i] = 1;
  if (dep === 4) {
    result = 1;
    return;
  }
  
  for (let j = 0; j < adjArr[i].length; ++j) {
    // 인접노드 이면서 미방문 노드
    const node = adjArr[i][j];
    if (!visit[node]) {
      dfs(node, dep + 1);
    }
  }
  visit[i] = 0;
}

for (let i = 0; i < n; ++i) {
  dfs(i, 0);
}

console.log(result)