package wang.gnim.netty.net.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public enum RedisSubPub {

	INSTANCE;
	
	private JedisPool pool;

	RedisSubPub() {
		pool = new JedisPool("10.234.10.12", 7006);
	}
	
	public void psubscribe(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
//			jedis.psubscribe();
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long publish(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.publish(key, value);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Long pubsubNumPat() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.pubsubNumPat();
		}
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, String> pubsubNumSub() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.pubsubNumSub();
		}
	}
}
