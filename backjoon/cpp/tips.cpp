#include <bits/stdc++.h>
#include "../split.cpp"

using namespace std;

int main() {
  string s;
  getline(cin, s);

  // pair & tuple
  int a; string b;
  // pair (make_pair(2, "test2"))
  pair<int, string> test = { 1, "test" };
  test.first = 2;
  test.second = "test2";
  // or
  tie(a, b) = test; // not using first & second property, alternative tie(var, var) # can use tuple

  // tuple
  int a1;
  string b1;
  char c1;
  tuple<int, string, char> test2 = make_tuple(1, "test", 'c');
  a1 = get<0>(test2);
  b1 = get<1>(test2);
  c1 = get<2>(test2);
  // or
  tie(a1, b1, c1) = test2;

  for(string splitVal : split(s, " ")) cout << splitVal << "\n";

  // Array
  // int arr[3] = {1, 2, 3};
  
  // next_permutation 할때 항상 sort 먼저! (do~while 할때)
  int perm_test_arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  sort(perm_test_arr, perm_test_arr + 10);

  // do {} while (next_permutation(perm_test_arr, perm_test_arr + 10))
  // do {} while (prev_permutation(perm_test_arr, perm_test_arr + 10))

  // lower_bound, upper_bound
  // lower_bound : 어떤 값이 나오는 최초 위치를 찾는다.
  // upper_bound : 어떤 값이 나오는 마지막 위치 그 다음의 위치를 찾는다. (거꾸로 탐색하여 발견시 그 이전의 위치를 찾는다.)
  vector<int> bound_test_vec = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  // v.begin() 을 빼주면 위치를 int 로 반환합니다. (시작 인덱스 0 기준)
  int low = (int)(lower_bound(bound_test_vec.begin(), bound_test_vec.end(), 5) - bound_test_vec.begin());
  int upp = (int)(upper_bound(bound_test_vec.begin(), bound_test_vec.end(), 5) - bound_test_vec.begin());
  cout << low << " " << upp << "\n";

  // rotate - 배열 회전
  vector<int> rotate_test_vec = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  // middle -> first 로 이동하며 회전 # begin + num 일 경우 num 만큼 잘라서 앞 -> 뒤로 보내고, begin - num 일 경우 뒤 -> 앞 로 민다.
  rotate(rotate_test_vec.begin(), rotate_test_vec.begin() + 3, rotate_test_vec.end());
  rotate(rotate_test_vec.begin(), rotate_test_vec.begin() + rotate_test_vec.size() - 5, rotate_test_vec.end());

  for(int val : rotate_test_vec) cout << val << "\n";

  // accumulate(begin, end, 0) - 배열 요소들의 합
  // max_element(begin, end) - 배열 요소중 최대값 추출
  vector<int> accumulate_test_vec = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  int sum = accumulate(accumulate_test_vec.begin(), accumulate_test_vec.end(), 0);
  int maxel = *max_element(accumulate_test_vec.begin(), accumulate_test_vec.end());
  cout << "SUM: " << sum << " MAX: " << maxel << "\n";

  // 배열 한칸씩 회전 - swap 을 회전할 만큼 수행
  vector<int> rotate_test_vec2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  int temp = rotate_test_vec2[1];
  rotate_test_vec2[1] = rotate_test_vec2[2];
  rotate_test_vec2[2] = rotate_test_vec2[3];
  rotate_test_vec2[3] = temp;
  cout << "ROTATE 1 cnt: " << "\n";
  for(int val : rotate_test_vec2) cout << val << "\n";

  return 0;
}