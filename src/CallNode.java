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
		if(!(obj instanceof Function))
			throw new ParseException(obj + " はみ定義の関数です" + name.where());
		
		Function func = (Function)obj;
		List<Object> vals = new ArrayList<Object>();
		for (Node arg : args) vals.add(arg.eval(env));
		if(func.arity() != vals.size())
			throw new ParseException(name + " は" + func.arity() + "引数の関数です" + where());
		return func.exec(vals);
	}
	
	public String toString() {
		return name + "(" + args.toString().replaceAll("^.|.$", "") + ")";
	}

}
