package ko.me;

import java.util.*;

// https://leetcode.com/problems/palindrome-pairs/description/
// Trie
public class _HARD_336_Palindrome_Pairs {

    static class TrieNode {
        TrieNode[] children;
        // 현재 노드에서 끝나는 단어의 인덱
        int index;
        // 현재 노드에서 끝나는 부분 문자열이 팰린드롬인 단어들의 인덱스 목록
        List<Integer> palindromeSuffixes;

        TrieNode() {
            children = new TrieNode[26]; // alphabet spellings
            index = -1;
            palindromeSuffixes = new ArrayList<>();
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // 단어를 뒤집어서 삽입 하면서, 현재까지의 접두사가 팰린드롬인지 확인하고 맞다면 palindromeSuffixes 에 추가
        public void insert(String word, int index) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (isPalindrome(word, 0, i)) {
                    node.palindromeSuffixes.add(index);
                }
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.index = index;
            node.palindromeSuffixes.add(index);
        }

        // 주어진 단어로 팰린드롬을 탐색하고, 탐색 중 부분 문자열이 팰린드롬인지 확인해서 맞다면 쌍을 이루는 인덱스를 같이 추가
        public List<List<Integer>> search(String word, int index) {
            List<List<Integer>> result = new ArrayList<>();
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                    result.add(List.of(index, node.index));
                }
                node = node.children[word.charAt(i) - 'a'];
                if (node == null) return result;
            }

            for (int i : node.palindromeSuffixes) {
                if (i != index) {
                    result.add(List.of(index, i));
                }
            }

            return result;
        }
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            result.addAll(trie.search(words[i], i));
        }

        return result;
    }

    public static void main(String[] args) {
        _HARD_336_Palindrome_Pairs solution = new _HARD_336_Palindrome_Pairs();
        String[] words = {"bat", "tab", "cat"};
        List<List<Integer>> result = solution.palindromePairs(words);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
