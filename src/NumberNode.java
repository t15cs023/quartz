
public class NumberNode extends Node{
	private int number; 
	
	public NumberNode(int line, int number) {
		super(line);
		this.number = number;
	}
	
	public Object eval(Env env){
		return (int)number;
	}
	
	public int number() {
		return number;
	}
	
	public String toString() {
		return Integer.toString(number);
	}
}
