const fs = require('fs');
// const inputData = fs.readFileSync(0, 'utf8').toString().split(' ');

const path = require('path');
const inputData = fs.readFileSync(path.resolve(__dirname, './dummy.txt'), 'utf8').toString().split('\n');

console.log(inputData)

const num = parseInt(inputData[0]);

const stack = [];

inputData.map((command, i) => {
  if (i > 0) {
    const _command = command.split(' ')[0];
    switch (_command) {
      case 'push':
        const _push_value = parseInt(command.split(' ')[1]);
        stack.shift(_push_value)
        break;
      case 'top':
        const _value = stack[stack.length - 1];
        if (_value) {
          console.log(_value)
          break;
        }
        console.log(-1)
        break;
      case 'pop':
        if (stack.length === 0) {
          console.log(-1)
          break;
        }
        console.log(stack.pop());
        break;
      case 'empty':
        if (stack.length === 0) {
          console.log(1)
          break;
        }
        console.log(0)
        break;
      default:
        break;
    }
  }
})
