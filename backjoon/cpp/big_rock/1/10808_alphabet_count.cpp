/**
 * @file 10808_alphabet_count.cpp
 * @author wontae kim
 * @brief
 * backjoon - 10808
 * 알파벳 세기
 * @version 0.1
 * @date 2022-07-30
 */
#include <bits/stdc++.h>

using namespace std;

int main() {
  string s;
  int result[26] = {0,};
  cin >> s;

  char str = 'a';
  while (str != 'z' + 1) {
    for (auto it = s.begin(); it != s.end(); ++it) {
      if (*it == str) {
        result[str - 'a']++;
      }
    }
    str++;
  }
 
  for (int i = 0; i < 26; ++i) {
    if (i == 25) {
      cout << result[i];
    } else {
      cout << result[i] << " ";
    }
  }

  return 0;
}