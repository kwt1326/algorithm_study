/**
 * @file 1213_make_palendrom.cpp
 * @author wontae kim
 * @brief
 * backjoon - 1213
 * 
 * 실패하는 경우 - 홀수개인 알파벳이 2가지 이상일때 불가능하다.
 * 
 * 풀이:
 * AAABB - A3B2 이므로 길이 / 2 = 2
 * 길이 2가 될때 까지 많은 알파벳 순으로 넣는다.
 * A remain - A2B2 -> A == B 이므로 B 를 넣는다.
 * AB remain - A2B1 -> 길이가 2개완성이므로 우측것을 거꾸로 하여 만든다.
 * AB, BA remain - A -> 길이 % 2 == 1 이므로 남은걸 가운데에 넣는다. PIECE~!
 * 
 * ABACABA - A4B2C1 # len = 3
 * A - A3B2C1
 * AA - AAB 완성
 * AAB, BAA 완성
 * A len + B len < 7 남은 C 가운데 넣음
 * AABCBAA
 * 
 * @version 0.1
 * @date 2022-00-00
 */
#include <bits/stdc++.h>

using namespace std;

string s;
int main()
{
  cin >> s;
  int len = s.length();
  char l[len];
  sort(s.begin(), s.end());

  int c = 0;
  int x = 0;
  char remain = 0;
  bool fail = 0;
  while (c < len) {
    int cnt = count(s.begin(), s.end(), s[c]);
    if (cnt % 2 == 1) {
      x++;
      remain = s[c];
    }
    if (x == 2) { // 홀수가 2개가 되는 순간 실패
      fail = 1;
      break;
    }
    
    if (cnt > 1) {
      // 같은 알파벳 배치 끝날때 까지 처리
      char val = s[c];
      for (int i = 0; i < cnt - 2; i += 2) {
        l[c] = val;
        l[len - c - 1] = val;
        c++;
      }
    } else {
      c++;
    }
    cnt = 0;
  }
  if (fail == 1) {
    cout << "I'm Sorry Hansoo";
    return 0;
  }
  if (len % 2 == 1) {
    l[len / 2] = remain;
  }
  for (char v:l) {
    cout << v;
  }
  
  return 0;
}