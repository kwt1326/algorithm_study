const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const input = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const logs = [];

for (let i = 0; i < input.length; ++i) {
  if (i > 0) {
    const value = input[i].split(' ');

    for (let j = 0; j < value.length; ++j) {
      const word = value[j].split('');
      for (let k = 0; k < word.length / 2; ++k) {
        [word[k], word[word.length - 1 - k]] = [word[word.length - 1 - k], word[k]]
      }
      value[j] = word.join('');
    }
    logs.push(value.join(' '));
  }
}

console.log(logs.join('\n'))
