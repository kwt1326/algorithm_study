#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> rotateMinus90(vector<vector<int>> arr) {
  int size = arr.size();
  vector<vector<int>> temp(size, vector<int>(size, 0));
  for (int i = 0; i < size; ++i) {
    for (int j = 0; j < size; ++j) {
      temp[i][j] = arr[j][size - i - 1]; // 오른쪽 회전 : arr[size - j - 1][i]
    }
  }
  return temp;
}

int main() {

  vector<vector<int>> v = {
    {1, 2, 3, 4, 5},
    {6, 7, 8, 9, 10},
    {11, 12, 13, 14, 15},
    {16, 17, 18, 19, 20},
    {21, 22, 23, 24, 25}
  };

  auto newV = rotateMinus90(v);

  for (auto a : newV) {
    for (auto b : a) {
      cout << b << " ";
    }
    cout << "\n";
  }

  return 0;
}