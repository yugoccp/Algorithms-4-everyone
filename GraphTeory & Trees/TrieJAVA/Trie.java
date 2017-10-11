import java.util.Scanner;

public class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode('/');
	}

	public boolean addWord(String word) {

		return addWord(root, word);
	}

	private boolean addWord(TrieNode root, String word) {
		if (word.length() == 0) {
			if (root.isWord) {
				return false;
			}
			root.isWord = true;
			return true;
		}

		char currentChar = word.charAt(0);
		if (!root.children.containsKey(currentChar)) {
			TrieNode newNode = new TrieNode(currentChar);
			root.children.put(currentChar, newNode);
		}
		return addWord(root.children.get(currentChar), word.substring(1));

	}

	public boolean checkWord(String word) {
		return checkWord(root, word);
	}

	public boolean checkWord(TrieNode root, String word) {
		if (word.length() == 0) {
			if (root.isWord) {
				return true;
			}
			return false;
		}
		char currentChar = word.charAt(0);
		if (!root.children.containsKey(currentChar)) {
			return false;
		}

		return checkWord(root.children.get(currentChar), word.substring(1));
	}

	public boolean removeWord(String word) {
		return removeWord(root, word);
	}

	private boolean removeWord(TrieNode root, String word) {

		if (word.length() == 0) {
			if (!root.isWord) {
				return false;
			}
			root.isWord = false;
			return true;
		}
		char currentChar = word.charAt(0);
		if (!root.children.containsKey(currentChar)) {
			return false;
		}

		TrieNode nextNode = root.children.get(currentChar);

		boolean smallResult = removeWord(nextNode, word.substring(1));
		if (!smallResult) {
			return smallResult;
		}

		if (!nextNode.isWord && nextNode.children.size() == 0) {
			root.children.remove(currentChar);
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Trie trie = new Trie();
		String word = "";
		int c;
		do {
			System.out.println("Enter Choice");
			System.out.println("1. Add Word");
			System.out.println("2. Search Word");
			System.out.println("3. Delete Word");
			System.out.println("4. Exit");
			c = s.nextInt();
			if (c != 4) {
				System.out.println("Enter Word");
				word = s.next();
			}
			switch (c) {
			case 1:
				boolean res = trie.addWord(word);
				if(res)
					System.out.println("Word Added");
				else
					System.out.println("Word not added/Already Present");
				break;
			case 2:
				boolean res1 = trie.checkWord(word);
				if(res1)
					System.out.println("Word Present");
				else
					System.out.println("Word Absent");
				break;
			case 3:
				boolean res11 = trie.removeWord(word);
				if(res11)
					System.out.println("Word Removed");
				else
					System.out.println("Word not removed/not found");
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid Input. Try Again.");
			}
			System.out.println();
		} while (c != 4);

	}
}
