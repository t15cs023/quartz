import java.util.ArrayList;
import java.util.List;

public class CallNode extends Node {
	private Node name;
	private List<Node> args;
	
	public CallNode(int line, Node name, List<Node> args) {
		super(line);
		this.name = name;
		this.args = args;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object obj = name.eval(env);
		
		List<Object> vals = new ArrayList<Object>();
		for (Node arg : args) vals.add(arg.eval(env));
		
		if(obj instanceof QuartzObj) {
			Env local = ((QuartzObj) obj).env();

			DotNode tmp = null;
			if(name instanceof DotNode)
				tmp = (DotNode)name;
			if(tmp.getRight().equals("new") && local.containsKey("initialize")) {
				Function init = (Function) local.get("initialize");
				init.exec(vals);
			}
			else if(local.containsKey(tmp.getRight())){
				if(local.get(tmp.getRight()) instanceof Function) {
					Function fun = (Function) local.get(tmp.getRight());
					fun.exec(vals);
				}
			}
			return obj;
		}
		
		if(!(obj instanceof Function)) {
			throw new ParseException(obj + " はみ定義の関数です" + name.where());
		}
		
		Function func = (Function)obj;
		if(func.arity() != vals.size())
			throw new ParseException(name + " は" + func.arity() + "引数の関数です" + where());
		return func.exec(vals);
	}
	
	public String toString() {
		return name + "(" + args.toString().replaceAll("^.|.$", "") + ")";
	}

}
