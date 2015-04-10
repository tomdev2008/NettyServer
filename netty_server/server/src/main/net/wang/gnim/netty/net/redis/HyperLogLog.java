package wang.gnim.netty.net.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public enum HyperLogLog {

	INSTANCE;
	
	private JedisPool pool;

	HyperLogLog() {
		pool = new JedisPool("10.234.10.12", 7006);
	}
	
	public void pfcount(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.pfcount(key, value);
		}
	}
	
	public void pfadd(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.pfadd(key, value);
		}
	}
	
	public void pfmerge(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.pfmerge(key, value);
		}
	}
}
