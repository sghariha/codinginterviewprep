public class Trie {
  public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
      this.children = new TrieNode[26];
      this.isEnd = false;
    }
  }

  private TrieNode root;

  Trie() {
    this.root = new TrieNode();
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("first");
    trie.insert("second");
    System.out.println("first is in trie: " + trie.search("first"));
    System.out.println("second is in trie: " + trie.search("second"));
  }

  public void insert(String input) {
    TrieNode current = this.root;
    for (int x = 0; x < input.length(); x++) {
      int index = input.charAt(x) - 'a';
      if (current.children[index] == null) {
        current.children[index] = new TrieNode();
      }
      current = current.children[index];
    }
    current.isEnd = true;
  }

  public boolean search(String input) {
    TrieNode current = this.root;
    for (int x = 0; x < input.length(); x++) {
      int index = input.charAt(x) - 'a';
      if (current.children[index] == null) {
        return false;
      }
      current = current.children[index];
    }
    return current.isEnd;
  }
}