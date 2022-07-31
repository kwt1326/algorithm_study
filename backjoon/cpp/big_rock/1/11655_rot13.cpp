/**
 * @file 11655_rot13.cpp
 * @author wontae kim
 * @brief
 * backjoon - 11655
 * 
 * @version 0.1
 * @date 2022-07-31
 */
#include <bits/stdc++.h>

using namespace std;

string s;
int main()
{
  getline(cin, s);
  if (s.length() <= 100) {
    for (int i = 0; i < s.size(); ++i) {
      if (isspace(s[i]) || ((s[i]) >= '0' == (s[i]) <= '9')) continue;
      char d = s[i] < 'a' ? 'Z' : 'z';
      s[i] = s[i] + 13 > d ? (s[i] + 13 - d + (s[i] < 'a' ? 'A' : 'a') - 1) : s[i] + 13;
    }
  }
  cout << s;

  return 0;
}