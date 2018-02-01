
public class ForNode extends Node {
	private Node i;
	private Node target;
	private Node block;
	
	public ForNode(int line, Node i, Node target, Node block) {
		super(line);
		this.i = i;
		this.target = target;
		this.block = block;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		LocalEnv local = new LocalEnv();
		local.setOuter(env);
		Object result = null;
		Object templist = target.eval(env);
		if(templist instanceof Array) {
			int j = 0;
			while(j < ((Array) templist).getBody().size()) {
				local.put(i.toString(), ((Array) templist).getBody().get(j));
				result = block.eval(local);
				j++;
			}
		}
		return result;
	}
	
	public String toString() {
		return "for (" + i + " in " + target + ") do (" + block + ") end";
	}
}
