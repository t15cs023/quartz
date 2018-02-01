
public class WhileNode extends Node {
	private Node cond;
	private Node block;
	
	public WhileNode(int line, Node cond, Node block) {
		super(line);
		this.cond = cond;
		this.block = block;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object result = null;
		while ((int)cond.eval(env) != 0)
			result = block.eval(env);
		return result;
	}
	
	public String toString() {
		return "while (" + cond + ") do (" + block + ") end";
	}
}
