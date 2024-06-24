package ko.me.dataStructure;

import java.util.*;

public class Trie {

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26]; // alphabet booleans
        public boolean word = false;
    }

    private final TrieNode root = new TrieNode();

    public Trie() {

    }

    public void insert(final String word) {
        TrieNode cur = root;
        for (final char c : word.toCharArray()) {
            final int asciiIdx = c - 'a';
            if (cur.children[asciiIdx] == null) {
                cur.children[asciiIdx] = new TrieNode();
            }
            cur = cur.children[asciiIdx];
        }
        cur.word = true;
    }

    public boolean search(final String word) {
        TrieNode cur = root;
        for (final char c : word.toCharArray()) {
            final int asciiIdx = c - 'a';
            if (cur.children[asciiIdx] == null) {
                return false;
            }
            cur = cur.children[asciiIdx];
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (final char c : prefix.toCharArray()) {
            final int asciiIdx = c - 'a';
            if (cur.children[asciiIdx] == null) {
                return false;
            }
            cur = cur.children[asciiIdx];
        }
        return true;
    }
}