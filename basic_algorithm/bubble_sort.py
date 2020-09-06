def bubble_sort(arr):
  for j in range(len(arr) - 1):
    for i in range(len(arr) - 1):
      if arr[i] > arr[i + 1]:
        temp = arr[i]
        arr[i] = arr[i + 1]
        arr[i + 1] = temp
  return arr

print(bubble_sort([1,5,4,6,2,3,9,7]))