import java.util.ArrayList;
import java.util.List;

public class DefArrayNode extends Node {
	private List<Node> body;
	private List<Object> contents;
	
	public DefArrayNode(List<Node> body) throws ParseException {
		this.body = body;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		contents = new ArrayList<>();
		for(Node n : body) {
			contents.add(n.eval(env));
		}
		return new Array(contents);
	}

}
