package algorithprac;

import java.util.HashMap;
import java.util.Map;

// 문자열 검색을 빠르게 실행할 수 있도록 설계한 트리 형태의 자료구조
public class Trie {
    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = this.rootNode;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);

            node.getChildNodes().putIfAbsent(c, new TrieNode());
            node = node.getChildNodes().get(c);
        }
        node.setLast(true);
    }

    boolean search(String word) {
        TrieNode node = this.rootNode;

        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);

            if(node.getChildNodes().containsKey(c)) {
                node = node.getChildNodes().get(c);
            } else {
                return false;
            }
        }

        return node.isLast();
    }

    public boolean deleteWord(String word) {
        boolean result = delete(this.rootNode, word, 0);

        return result;
    }

    private boolean delete(TrieNode node, String word, int idx) {
        char c = word.charAt(idx);

        if(!node.getChildNodes().containsKey(c)) {
            return false;
        }

        TrieNode curNode = node.getChildNodes().get(c);
        idx++;
        if(idx == word.length()) {
            if(!curNode.isLast()) {
                return false;
            }

            curNode.setLast(false);

            if(curNode.getChildNodes().isEmpty()) {
                node.getChildNodes().remove(c);
            }
        } else {
            if(!this.delete(curNode, word, idx)) {
                return false;
            }

            if(!curNode.isLast() && curNode.getChildNodes().isEmpty()) {
                node.getChildNodes().remove(c);
            }
        }
        return true;
    }


    static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLast;

        public Map<Character, TrieNode> getChildNodes() {
            return childNodes;
        }

        public boolean isLast() {
            return isLast;
        }

        public void setLast(boolean last) {
            isLast = last;
        }
    }
}
