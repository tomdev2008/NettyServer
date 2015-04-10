package wang.gnim.netty.net.netty.http;

import java.util.HashMap;
import java.util.Map;

import wang.gnim.netty.server.util.JsonTool;

public class HttpParamaters {

	public String scheme;
	public Map<String, String> parameters = new HashMap<>();
	
	public String toString() {
		return JsonTool.toJson(this);
	}
}
