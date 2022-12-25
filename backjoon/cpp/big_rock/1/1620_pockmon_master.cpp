/**
 * @file 1620_pockmon_master.cpp
 * @author wontae kim
 * @brief
 * backjoon - 1620
 * 
 * map(자동정렬 맵) 사용 문제
 * "시간초과"에 민감한 문제이니 주의!
 * 
 * map => (insert, delete, modify) all [ O(log n) ]
 * 
 * @version 0.1
 * @date 2022-08-06
 */
#include <bits/stdc++.h>

using namespace std;

int n, m;
string buf;
map<string, int> mp;
map<int, string> rmp;
int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
  cin >> n;
  cin >> m;

  for (int i = 0; i < n; ++i) {
    cin >> buf;
    mp[buf] = i + 1;
    rmp[i + 1] = buf;
  }
  for (int i = 0; i < m; ++i) {
    cin >> buf;
    if (atoi(buf.c_str()) != 0) {
      cout << rmp[atoi(buf.c_str())] << "\n";
      continue;
    }
    cout << mp[buf] << "\n";
  }

  return 0;
}
