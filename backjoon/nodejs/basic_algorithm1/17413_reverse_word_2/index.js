/**
 * https://www.acmicpc.net/problem/17413
 * Not Solved,
 * 백준 제출시 실패로 나오는데 왜 실패인지 모르겠음..
 * 결과는 모든 케이스 제대로 나옴
 */ 

const fs = require('fs');
// const input = fs.readFileSync("/dev/stdin").toString().trim();
const input = fs.readFileSync("dummy.txt").toString().trim();

let log = '';
let isOpen = false, startIdx = 0, endIdx = 0;

let arr = input.split('');

arr.forEach((v, i) => {
  if (v === ' ' && isOpen === false) {
    endIdx = i;
    log += arr.slice(startIdx, endIdx).reverse().join('')
    startIdx = i + 1;
    log += v;
  }

  if (v === '<') {
    if (log.length > 0) {
      endIdx = i;
      log += arr.slice(startIdx, endIdx).reverse().join('')
    }
    isOpen = true;
    log += v;
    return;
  }
  
  if (v === '>') {
    isOpen = false;
    startIdx = i + 1;
    log += v;
    return;
  }

  if (isOpen) {
    log += v;
  }
})

if (arr[arr.length - 1] !== '>') {
  endIdx = arr.length;
  log += arr.slice(startIdx, endIdx).reverse().join('')
}

console.log(log.replace(/\n/g, ""));

/**

아래는 맞았다고 나오는 다른 코드이다.

var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('');

var stack = [];
var queue = [];
var answer = '';
var isOpen = false;
var size = input.length + 1;
for (var i = 0; i < size; i++) {
    var ch = input[i];
    if (ch === '<') {
        isOpen = true;
        if (stack.length > 0) {
            answer += stack.reverse().join('');
            stack = [];
        }
    } else if (ch === '>') {
        isOpen = false;
        answer += queue.join('') + ch;
        queue = [];
        continue;
    } else if ((ch === ' ' && !isOpen) || ch === undefined) {
        answer += stack.reverse().join('').trim() + (ch === ' ' ? ch : '');
        stack = [];
        continue;
    }
    
    if (isOpen) {
        queue.push(ch);
    } else if (!isOpen) {
        stack.push(ch);
    }
}
console.log(answer);

 */
