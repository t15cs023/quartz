import java.util.List;

public class Array {
	private List<Object> body;
	
	public Array(List<Object> body) throws ParseException {
		this.body = body;
	}
	
	public Object exec(int index) throws ParseException {
		return body.get(index);
	}
	
	public String toString(){
		String str = "[";
		for(Object n : body) {
			str += n.toString();
			if(!n.equals(body.get(body.size()-1)))
				str += ",";
		}
		str += "]";
		return str;
	}

	public List<Object> getBody() {
		return body;
	}
}
