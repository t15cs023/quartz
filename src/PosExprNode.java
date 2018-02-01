
public class PosExprNode extends Node{
	private Node val;
	
	public PosExprNode(int line, Node val) {
		super(line);
		this.val = val;
	}
	
	public Object eval(Env env) throws ParseException {
		return (int)val.eval(env);
	}

	public String toString() {
		return "(" + val + ")";
	}
}
