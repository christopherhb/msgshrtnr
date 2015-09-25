
public class Message {
	private String msg;
	private int charCount;
	
	public Message(String msg) {
		this.msg = msg;
	}
	
	public void print() {
		System.out.println(msg);
	}
	
	public int getCharCount() {
		return msg.length();
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
