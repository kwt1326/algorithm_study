/**
 * @file 9996_korea_server.cpp
 * @author wontae kim
 * @brief
 * backjoon - 9996
 * 
 * 주의 ! "반례 체크" (패턴길이 합보다 이름이 더 길어야 함)
 * 문제 테스트 케이스와 달리 패턴의 문자열 길이는 명시돼있지 않음 (* 을 기준으로 몇글자든 가능하다는 것)
 * 
 * @version 0.1
 * @date 2022-07-31
 */
#include <bits/stdc++.h>

using namespace std;

vector<string> split(string s, string del) {
  vector<string> r;
  long long pos = 0;
  string token = "";

  while ((pos = s.find(del[0])) != string::npos) {
    token = s.substr(0, pos);
    r.push_back(token);
    s.erase(0, pos + del.length());
  }
  r.push_back(s);
  return r;
}

int n;
string p;
string s;
vector<string> results;
int main()
{
  cin >> n;
  cin >> p;

  vector<string> sp = split(p, "*");
  string st = sp[0];
  string ed = sp[1];

  for (int i = 0; i < n; ++i) {
    cin >> s;
    if (p.size() - 1 <= s.size()) {
      if (s.substr(0, st.size()) == st && s.substr(s.size() - ed.size(), ed.size()) == ed) {
        results.push_back("DA");
        continue;
      }
    }
    results.push_back("NE");
  }

  for (string v : results) {
    cout << v << "\n";
  }

  return 0;
}