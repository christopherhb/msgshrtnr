import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MessageShortener {
	private HashMap<String, String> wordPairs;
	
	public MessageShortener() {
		this.wordPairs = new HashMap<String, String>();
		Scanner sc;
		try {
			sc = new Scanner(new FileReader("Dictionary.txt"));
	    	String input;
	    	String[] splitInput;
	    	
			// put all the words into a hashmap
			while (sc.hasNext()) {
		    	input = sc.nextLine();
		    	splitInput = input.split("\\s+");
		    	wordPairs.put(splitInput[0], splitInput[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void shortenMessage(Message msg) {
		String str = msg.getMsg();
		
		// split the message
		String[] words = str.split("\\s+");
		String word;
		for (int i = 0; i < words.length; i++) {
			word = words[i].toLowerCase();
			if (wordPairs.containsKey(word)) {
				words[i] = wordPairs.get(word);
			}
		}
		
		// rebuild the message
		StringBuilder resultMsg = new StringBuilder();
		for(String s : words) {
		    resultMsg.append(s);
		    resultMsg.append(" ");
		}
		
		msg.setMsg(resultMsg.toString());
	}
}
