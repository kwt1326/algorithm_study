import sys

def select_sort(arr):
  return_arr = arr.copy()
  idx = 0
  for i in range(len(return_arr)):
    min = sys.maxsize
    for j in range(i, len(return_arr)):
      if return_arr[j] < min:
        min = return_arr[j]
        idx = j
    temp = return_arr[idx]
    return_arr[idx] = return_arr[i]
    return_arr[i] = temp
  return return_arr

print(select_sort([1,5,9,4,8,2,7,3,6]))