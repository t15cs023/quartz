
public class ReferenceArray extends Node {
	private Node name;
	private Node index;
	public ReferenceArray(int line, Node name, Node index) {
		super(line);
		this.name = name;
		this.index = index;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object obj = name.eval(env);
		if(!(obj instanceof Array))
			throw new ParseException(obj + " はみ定義の配列です" + name.where());
		Array arr = (Array)obj;

		Object index = this.index.eval(env);
		if(!(index instanceof Integer))
			throw new ParseException(index + " は整数ではありません" + name.where());
		int ind = (int)index;
		
		return arr.exec(ind);
	}

}
