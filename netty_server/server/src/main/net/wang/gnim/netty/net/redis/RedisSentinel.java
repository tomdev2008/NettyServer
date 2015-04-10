package wang.gnim.netty.net.redis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public enum RedisSentinel {

	INSTANCE;
	
	private JedisPool pool;

	RedisSentinel() {
		pool = new JedisPool("10.234.10.12", 7006);
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<Map<String, String>> sentinelMasters() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelMasters();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<String> sentinelGetMasterAddrByName(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelGetMasterAddrByName(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Map<String, String>> sentinelSlaves(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelSlaves(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelFailover(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelFailover(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelMonitor(String name, int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelMonitor(name, name, ordinal, ordinal);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelRemove(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.sentinelRemove(name);
		}
	}
}
