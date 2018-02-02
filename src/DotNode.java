
public class DotNode extends Node {
	private Node left;
	private String right;
	
	public DotNode(int line, Node left, String right) {
		super(line);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object leftobj = left.eval(env);
		if(!(leftobj instanceof QuartzClass) && !(leftobj instanceof QuartzObj))
			throw new ParseException(leftobj + " は未定義のクラスです");
		if(leftobj instanceof QuartzObj) {
			if(((QuartzObj) leftobj).env().containsKey(right)) return ((QuartzObj) leftobj).env().get(right);
		}
		QuartzClass leftclass = (QuartzClass) leftobj;
		QuartzObj qobj = leftclass.create(env);
		return qobj;
	}

	public String getRight() {
		return right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public String toString() {
		return left.toString() + "." + right;
	}

}
