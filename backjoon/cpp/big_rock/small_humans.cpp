/**
 * @file small_humans.cpp
 * @author wontae kim
 * @brief
 * backjoon - 2309
 * 9명중 7명을 골라 합이 100 인 순열 오름차순 추출
 * @version 0.1
 * @date 2022-07-24
 */
#include <bits/stdc++.h>

using namespace std;

// vector<int> v = {20, 7, 23, 19, 10, 15, 25, 8, 13};
// vector<int> b;
int v[9];
int count = 0;
bool printed = false;

// void combination(int s, int k, vector<int> buf) {
//   if (printed) return;
//   if (buf.size() == k) {
//     int sum = accumulate(buf.begin(), buf.end(), 0);
//     if (sum == 100) {
//       sort(buf.begin(), buf.end());
//       for (int i = 0; i < buf.size(); ++i) {
//         if (i == buf.size() - 1) {
//           cout << buf[i];
//         } else {
//           cout << buf[i] << "\n";
//         }
//       }
//       printed = true;
//       return;
//     }
//   }
//   for (int i = s; i < v.size(); ++i) {
//     buf.push_back(v[i]);
//     combination(i + 1, k, buf);
//     buf.pop_back();
//   }
// }

// do~while permutation 할때는 항상 sort 먼저 하기
void permutation() {
  sort(v, v + 9);
  do {
    int sum = 0;
    for (int i = 0; i < 7; ++i) {
      sum += v[i];
    }
    if (sum == 100) {
      for (int i = 0; i < 7; ++i) {
        cout << v[i] << "\n";
      }
      break;
    }
 // next_permutation 은 원본 배열이 오름차순 정렬되어 계속 순서가 바뀌기 때문에 해당 배열을 계속 테스트 하면 답이 나온다.
  } while(next_permutation(v, v + 9));
}

int main() {
  for (int i = 0; i < 9; ++i) {
    cin >> v[i];
  }

  // combination(0, 7, b);
  permutation();

  return 0;
}