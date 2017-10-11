import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character,TrieNode> children;
	boolean isWord;
	char ch;
	TrieNode(char ch){
		isWord = false;
		children = new HashMap<>();
		this.ch = ch;
	}
}
