/**
 * @file 1159_basketball.cpp
 * @author wontae kim
 * @brief
 * backjoon - 1159
 * 
 * @version 0.1
 * @date 2022-07-31
 */
#include <bits/stdc++.h>

using namespace std;

int n;
int alp[26] = {0,};
vector<char> res;
string name;
int main()
{
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> name;
    alp[name[0] - 'a']++;
  }
  for (int i = 0; i < 26; ++i) {
    if (alp[i] > 4) {
      res.push_back((char)(i + 'a'));
    }
  }
  if (res.size() == 0) {
    cout << "PREDAJA";
  } else {
    for (int i = 0; i < res.size(); ++i) {
      cout << res[i];
    }
  }
  return 0;
}