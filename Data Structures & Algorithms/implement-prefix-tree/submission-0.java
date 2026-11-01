class PrefixTree {
    public TrieNode root;

    public PrefixTree() {
         root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
            if (cur.children[ c -'a'] == null){
                cur.children[ c - 'a'] = new TrieNode(c);
            } 
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()){
            if (cur.children[c- 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;

    }
}

class TrieNode{
    boolean isWord;
    char val;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(char c){
        this.val = c;
    }
}
