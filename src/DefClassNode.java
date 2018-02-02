import java.util.List;

public class DefClassNode extends Node {
	private String name;
	private List<Node> members;
	public DefClassNode(int line, String name, List<Node> members) {
		super(line);
		this.name = name;
		this.members = members;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		// TODO 自動生成されたメソッド・スタブ
		return env.put(name, new QuartzClass(members));
	}
	
	/*
	@Override
	public Object eval(Env env) throws ParseException {
		return env.put(name, new Function(env, params, body));
	}
	 */
	
	public String toString() {
		String str = "class " + name + "\n";
		for(Node n : members) {
			str += n.toString() + "\n";
		}
		str += "end";
		return str;
	}
}
