function bubble_sort(arr) {
  for (let i = 0; i < arr.length - 1; ++i) {
    for (let j = i + 1; j < arr.length; ++j) {
      if (arr[i] > arr[j]) {
        let buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
      }
    }
  }

  return arr;
}

console.log(bubble_sort([4,39,9,5,65,34,23]));


