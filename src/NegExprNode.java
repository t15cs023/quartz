
public class NegExprNode extends Node{
	private Node val;

	public NegExprNode(int line, Node val) {
		super(line);
		this.val = val;
	}
	
	public Object eval(Env env) throws ParseException {
		return -1*(int)val.eval(env);
	}

	public String toString() {
		return "(-" + val + ")";
	}
}
