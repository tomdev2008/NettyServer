package wang.gnim.netty.net.httpClient;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import wang.gnim.netty.net.httpClient.HTTPClient;


public class TestHttpClient {

	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.put("123", "asf");
		HTTPClient.INSTANCE.post("http://127.0.0.1:10021/online", map);
	}
}
