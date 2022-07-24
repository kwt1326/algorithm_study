#include <bits/stdc++.h>
using namespace std;

vector<string> split(string input, string delimeter) {
  vector<string> result;
  stringstream ss(input);
  string token;
  while (getline(ss, token, delimeter[0])) {
    result.push_back(token);
  }
  return result;
}

vector<string> split2(string input, string delimiter) {
  vector<string> ret;
  long long pos = 0;
  string token = "";
  while ((pos = input.find(delimiter)) != string::npos)
  {
    token = input.substr(0, pos);
    ret.push_back(token);
    input.erase(0, pos + delimiter.length());
  }
  ret.push_back(input);
  return ret;
}

// int main() {
//   string s;
//   getline(cin, s);
//   vector<string> result = split(s, " ");
//   for(string val : result) cout << val << "\n";
//   return 0;
// }
