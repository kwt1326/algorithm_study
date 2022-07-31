/**
 * @file 2559_numeric_arr.cpp
 * @author wontae kim
 * @brief
 * backjoon - 2559
 * 
 * 최소값부터 설정! (100000 * 최소정수 -100)
 * 구간합 사용시 i = 1 부터 만듬
 * 
 * 구간합 ex)
 * int inputs[5] = {1, 2, 3, 4, 5}
 * int psum[100001] = {0 (default), 1(i - 1(0) + 1), 3(i - 1(1) + 2), 6, 10, 15...}
 * 
 * 만약 구간쿼리값(k)이 2 일 경우
 * 
 * int result = psum[n] - psum[n - 2]
 * 
 * 로 n 에서 k 만큼의 구간만의 합을 추출할 수 있다.
 * 
 * @version 0.1
 * @date 2022-07-31
 */
#include <bits/stdc++.h>

using namespace std;

int n, k, buf, _max = -10000004;
int psum[100001]; // i = 1 부터 넣으므로 +1
int main()
{
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) {
    cin >> buf; psum[i] = buf + psum[i - 1];
  }
  for (int i = k; i <= n; ++i) {
    _max = max(_max, psum[i] - psum[i - k]);
  }
  cout << _max << "\n";
  return 0;
}