/**
 * https://www.acmicpc.net/problem/10799
 * 
 * 스택 사용
 */

const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim();
// const input = fs.readFileSync("dummy.txt").toString().trim();

const arr = input.split('')

let stack = [];
let stick = 0;
let count = 0;

for (v of arr) {
  if (v === '(') {
    if (stack[stack.length - 1] === '(') {
      stick++;
      continue;
    }
    stack.push(v)
  } else {
    if (stack[stack.length - 1] === '(') {
      stack.pop();
      count += stick;
    } else {
      count++;
      stick--;
    }
  }
}

console.log(count)

/**
 * 더 짧게 하는 코드 예시
 * stick 을 stack 에 '(' 를 누적해서 길이로 사용,
 * ')' 가 나오면 pop 하여 길이 줄임
 */

//  var stack = [];
//  var answer = 0;
//  for(var i in input){
//      if(input[i] === '('){
//          stack.push(input[i]);
//      }else{
//          if(input[i-1] === '('){
//              stack.pop();
//              answer += stack.length;
//          }else{
//              stack.pop();
//              answer ++;
//          }
//      }
//  }
//  console.log(answer);