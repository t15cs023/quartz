import java.util.List;

public class QuartzClass {
	private List<Node> members;

	public QuartzClass(List<Node> members) {
		this.members = members;
	}

	public QuartzObj create(Env env) throws ParseException {
		//未実装
		LocalEnv local = new LocalEnv();
		for(Node member : members) {
			member.eval(local);
		}
		for(String s : local.keySet()) {
			System.out.println(s+ " : " + local.get(s));
		}
		System.out.println("--");
		local.setOuter(env);
		return new QuartzObj(local);
	}
	
	public List<Node> getMembers() {
		return members;
	}
}
