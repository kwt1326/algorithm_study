const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const input = fs.readFileSync("dummy.txt").toString().trim().split("\n");

const stack = [];
const logs = [];

input.map((command, i) => {
  if (i > 0) {
    const _command = command.split(' ')[0];

    switch (_command) {
      case 'push':
        const _push_value = parseInt(command.split(' ')[1]);
        stack.push(_push_value)
        break;
      case 'top':
        const _value = stack[stack.length - 1];
        if (_value) {
          logs.push(_value)
          break;
        }
        logs.push(-1)
        break;
      case 'pop':
        if (stack.length === 0) {
          logs.push(-1)
          break;
        }
        logs.push(stack.pop());
        break;
      case 'empty':
        if (stack.length === 0) {
          logs.push(1)
          break;
        }
        logs.push(0)
        break;
      case 'size':
        logs.push(stack.length)
        break;
      default:
        break;
    }
  }
})

console.log(logs.join('\n'));
