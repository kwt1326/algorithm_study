#include <bits/stdc++.h>
using namespace std;

// 소수 판별 배열 생성
vector<int> era(int mx_n) {
  bool che[mx_n];
  fill(che, che + mx_n, false);

  vector<int> v;
  for (int i = 2; i <= mx_n; i++)
  {
    // 소수의 배수를 소수 체크 했는지 검사 (true 면 배수로써 소수가 아님)
    if (che[i])
      continue;
    // 검사할 소수의 배수부터 시작 (소수는 true 를 넣지 않음)
    for (int j = 2 * i; j <= mx_n; j += i)
    {
      che[j] = true;
    }
  }
  for (int i = 2; i <= mx_n; i++)
  { // 한번도 걸리지 않은 소수만(false) 추가
    if (che[i] == false)
      v.push_back(i);
  }
  return v;
}

// 소수 판별 함수
bool check(int n)
{
  if (n <= 1)
    return 0;
  if (n == 2)
    return 1;
  if (n % 2 == 0)
    return 0;
  // i 는 판별할 수를 넘지 않는다.
  for (int i = 2; i * i <= n; i++)
  {
    if (n % i == 0)
      return 0;
  }
  return 1;
}

int main() {
  vector<int> _era = era(100);

  for (int i = 0; i < _era.size(); i++) {
    cout << _era[i] << "\n";
  }

  string result = check(100) ? "소수입니다" : "소수가 아닙니다";
  cout << result << "\n";

  return 0;
}