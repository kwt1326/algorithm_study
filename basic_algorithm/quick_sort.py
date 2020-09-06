def quick_sort(arr):
  if len(arr) <= 1:
    return arr
  else:
    pivot_idx = int(len(arr) / 2)
    left = []
    right = []
    for i in range(len(arr)):
      if i == pivot_idx:
        continue
      elif arr[i] < arr[pivot_idx]:
        left.append(arr[i])
      else:
        right.append(arr[i])
    return quick_sort(left) + [arr[pivot_idx]] + quick_sort(right)

print(quick_sort([1,5,4,6,2,3,9,7,8,13,12,17,15,99,100,66]))