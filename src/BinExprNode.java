import java.util.ArrayList;
import java.util.List;

public class BinExprNode extends Node{
	private Node left;
	private String op;
	private Node right;
	
	public BinExprNode(int line, Node left, String op, Node right) {
		super(line);
		this.left = left;
		this.op = op;
		this.right = right;
	}
	
	public Object eval(Env env) throws ParseException {
		Object lval = left.eval(env);
		Object rval = right.eval(env);
		if(lval instanceof Integer && rval instanceof Integer) {
			switch(op) {
			case "+": return (int)lval + (int)rval;
			case "-": return (int)lval - (int)rval;
			case "*": return (int)lval * (int)rval;
			case "/": return (int)lval / (int)rval;
			case "%" : return (int)lval % (int)rval;
			case "||": if(((int)lval==0)&&((int)rval==0)) return 0; else return 1;
			case "&&": if(((int)lval!=1)&&((int)rval!=1)) return 0; else return 1;
			case "<": if((int)lval < (int)rval) return 1; else return 0;
			case ">": if((int)lval > (int)rval) return 1; else return 0;
			case "<=": if((int)lval <= (int)rval) return 1; else return 0;
			case ">=": if((int)lval >= (int)rval) return 1; else return 0;
			case "==": if((int)lval == (int)rval) return 1; else return 0;
			case "!=": if((int)lval != (int)rval) return 1; else return 0;
			default: throw new ParseException(op + " は未定義のオペレータです " + where());
			}
		}
		
		if(lval instanceof Array && rval instanceof Array) {
			switch(op) {
			case "+":
				Array left = (Array)lval;
				List<Object> lvallist = left.getBody();
				Array right = (Array)rval;
				List<Object> rvallist = right.getBody();
				List<Object> temp = new ArrayList<>();
				for(Object obj : lvallist) {
					temp.add(obj);
				}
				for(Object obj : rvallist) {
					temp.add(obj);
				}
				return new Array(temp);
			}
		}
		
		String lstr = lval.toString();
		String rstr = rval.toString();
		if(op.equals("+"))
			return lstr + rstr;
		throw new ParseException("文字列に対する" + op + "は未定義のオペレータです" + where());
	}

	public String toString() {
		return "(" + left + " " + op + " " + right + ")";
	}
}
