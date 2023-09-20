import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
    private final Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }

        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return false; // Character not found
            }
            current = node;
        }

        return current.isEndOfWord();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert word");
            System.out.println("2. Search word");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter word to insert: ");
                    String insertWord = scanner.nextLine();
                    trie.insert(insertWord);
                    System.out.println("'" + insertWord + "' inserted into Trie.");
                    break;
                case 2:
                    System.out.print("Enter word to search: ");
                    String searchWord = scanner.nextLine();
                    boolean found = trie.search(searchWord);
                    System.out.println("'" + searchWord + "' " + (found ? "found" : "not found") + " in Trie.");
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

