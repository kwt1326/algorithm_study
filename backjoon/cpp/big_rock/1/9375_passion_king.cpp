/**
 * @file 9375_passion_king.cpp
 * @author wontae kim
 * @brief
 * backjoon - 9375
 * 
 * 순서 상관없이 카테고리별 1개 이하로 가능한 모든 개수의 조합
 * (카테고리 2가지면 2가지의 속한 아이템 간의 모든 조합 + 아이템 하나씩 입은 것까지 계산)
 * 
 * @version 0.1
 * @date 2022-08-06
 */
#include <bits/stdc++.h>

using namespace std;

int n;
int nn;
int result = 1;
string w, t;
unordered_map<string, int> m;
int main()
{
  cin >> n;
  while (n--) {
    result = 1;
    m.clear();

    cin >> nn;
    for (int i = 0; i < nn; ++i) {
      cin >> w >> t;
      m[t]++;
    }
    for (auto v: m) {
      result *= v.second + 1;
    }
    cout << --result << "\n";
  }

  return 0;
}