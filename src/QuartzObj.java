
public class QuartzObj {
	private LocalEnv inner;
	
	public QuartzObj(LocalEnv env) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.inner = env;
	}
	
	public Env env() {
		return inner;
	}

	public String toString(){
		if(inner.containsKey("to_s") && inner.get("to_s") instanceof Function) {
			Function toS = (Function)inner.get("to_s");
			try {
				return (String)toS.exec(null);
			} catch (ParseException e) {
				e.printStackTrace();
				return "to_s関数が定義されていません。error";
			}
		}
		else {
			return "to_s関数が定義されていません。";
		}
	}
}
