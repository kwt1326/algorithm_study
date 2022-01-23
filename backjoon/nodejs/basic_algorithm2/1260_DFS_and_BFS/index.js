/**
 * https://www.acmicpc.net/problem/1260
 */

const fs = require('fs');
const [input, ...arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const [input, ...arr] = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const [nd, nl, start] = input.split(' ');

const parseData = arr.map((v) => v.split(' ').map(_ => parseInt(_)));
let visit1 = [false, ...Array(parseInt(nd)).fill('').map(_ => false)];
let visit2 = [false, ...Array(parseInt(nd)).fill('').map(_ => false)];
let resultDFS = [], resultBFS = [];
let queue = [];

const graph = [];

for (v of parseData) {
  graph.push([v[0], v[1]])
  graph.push([v[1], v[0]])
}

function dfs(g, i, visit1) {
  resultDFS.push(i);
  visit1[i] = true;

  let _g = g.filter(v => v[0] === i);
  _g.sort((a, b) => a[1] - b[1]);

  for (row of _g) {
    if (visit1[row[1]] === false) {
      dfs(g, row[1], visit1)
    }
  }
}

function bfs(g, i, visit2) {
  let _g = g.filter(v => v[0] === i);
  _g.sort((a, b) => a[1] - b[1]);
  
  for (v of _g) {
    queue.push(v[1]);
  }
  resultBFS.push(i);
  visit2[i] = true;

  while (queue.length !== 0) {
    const q = queue.shift();
    if (visit2[q] === false) {
      let _g = g.filter(v => v[0] === q);
      _g.sort((a, b) => a[1] - b[1]);

      for (v of _g) {
        queue.push(v[1]);
      }
      resultBFS.push(q);
      visit2[q] = true;
    }
  }
}

dfs(graph, parseInt(start), visit1)
bfs(graph, parseInt(start), visit2)
console.log(`${resultDFS.join(' ')}\n${resultBFS.join(' ')}`)