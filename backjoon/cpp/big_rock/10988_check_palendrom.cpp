/**
 * @file 10988_check_palendrom.cpp
 * @author wontae kim
 * @brief
 * backjoon - 10988
 * 팰린드롬인지 확인하기
 * 
 * string temp = s;
 * reverse(temp.begin(), temp.end());
 * 를 사용하여 원본 배열과 통째로 비교해도 됨
 * 
 * @version 0.1
 * @date 2022-07-30
 */
#include <bits/stdc++.h>

using namespace std;

int main() {
  string s;
  cin >> s;
  int l = s.length();
  int cnt = 0;

  while (cnt < l / 2) {
    if (s[cnt] != s[l - cnt - 1]) {
      cout << 0;
      return 0;
    }
    cnt++;
  }

  cout << 1;
  return 0;
}