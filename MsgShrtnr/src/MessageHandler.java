import java.util.Scanner;

public class MessageHandler {
	private MessageShortener shorten;
	private Message current;
	
	public static void main(String args[]) {
		MessageHandler mh = new MessageHandler();
	    Scanner sc = null;
	    try
	    {
	        sc = new Scanner(System.in);
	        while (sc.hasNext()) {
		        mh.shorten(sc.nextLine());
		        mh.print();
	        }
	    }
	    finally
	    {
	        if (sc != null) sc.close();
	    }
	}
	
	public MessageHandler() {
		this.shorten = new MessageShortener();
	}
	
	public void shorten(String originalMsg) {
		this.current = new Message(originalMsg);
		shorten.shortenMessage(current);
	}
	
	public void print() {
		current.print();
	}
}
