class TrieNode{
    TrieNode [] childern = new TrieNode[26];
    boolean isEndOfWord = false;
}
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index]; 
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                return false;
            }
            
            curr = curr.childern[index];  
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                return false;
            }
            
            curr = curr.childern[index]; 
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */