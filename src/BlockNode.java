import java.util.List;

public class BlockNode extends Node {
	private List<Node> nodes;
	
	public BlockNode(List<Node> nodes) {
		super();
		this.nodes = nodes;
	}
	
	public Object eval(Env env) throws ParseException {
		Object result = 0;
		for(Node node : nodes) {
			result = node.eval(env);
		}
		return result;
	}
	
	public String toString() {
		//return "BlockNode [nodes=" + nodes + "]";
		return "" + nodes + "";
	}
}
