/**
 * @file 2979_truck_parking.cpp
 * @author wontae kim
 * @brief
 * backjoon - 2979
 * 
 * 트럭 3개를 주차하는데 A,B,C 요금을 겹치는 시간대에 맞춰서 적용시키면 된다.
 * 시간이 주어지는데, 겹치는 시간대가 있다면 할인 혜택이 주어진다.
 * 시간은 시작 이상, 종료 미만으로 처리하는게 좋다.
 * 
 * @version 0.1
 * @date 2022-07-30
 */
#include <bits/stdc++.h>

using namespace std;

int main() {
  int a, b, c;
  int countArr[100] = {0,};
  int sum = 0;
  int dist, leave;
  cin >> a >> b >> c;

  for (int i = 0; i < 3; ++i) {
    cin >> dist >> leave;
    for (int j = dist; j < leave; ++j) {
      countArr[j] += 1;
    }
  }

  for (int i = 0; i < 100; ++i) {
    switch (countArr[i])
    {
    case 1:
      sum += a;
      break;
    case 2:
      sum += b * 2;
      break;
    case 3:
      sum += c * 3;
      break;
    default:
      break;
    }
  }

  cout << sum;
  return 0;
}