package wang.gnim.netty.net.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 在不同的线程中使用相同的Jedis实例会发生奇怪的错误.但是创建太多的实现也不好因为这意味着会建立很多sokcet连接,
 * 也会导致奇怪的错误发生.单一Jedis实例不是线程安全的.为了避免这些问题,可以使用JedisPool,
 * JedisPool是一个线程安全的网络连接池.可以用JedisPool创建一些可靠Jedis实例,可以从池中拿到Jedis的实例.
 * 这种方式可以解决那些问题并且会实现高效的性能
 * 
 */
public enum RedisClient {

	INSTANCE;
	
	private JedisPool pool;

	RedisClient() {
		pool = new JedisPool("10.234.10.12", 7006);
	}

	/**
	 * 
	 * @param jedis
	 */
	public void close(Jedis jedis) {
		jedis.close();
	}

	public void bitpos(String key, boolean value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.bitpos(key, value);
		}
	}

	public void sentinelReset(String name) {
		try (Jedis jedis = pool.getResource()) {
			jedis.sentinelReset(name);
		}
	}

	public void sentinelSet(String name) {
		try (Jedis jedis = pool.getResource()) {
			jedis.sentinelSet(name, null);
		}
	}

	public void asking() {
		try (Jedis jedis = pool.getResource()) {
			jedis.asking();
		}
	}
	
	public void setDataSource() {
		try (Jedis jedis = pool.getResource()) {
			jedis.setDataSource(pool);
		}
	}

	public void pubsubChannels(String name) {
		try (Jedis jedis = pool.getResource()) {
			jedis.pubsubChannels(name);
		}
	}

	public void expireAt(String key, long value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.expireAt(key, value);
		}
	}

	public void substr(String name) {
		try (Jedis jedis = pool.getResource()) {
			jedis.substr(name, 0, 0);
		}
	}

	public void sunionstore(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.sunionstore(key, value);
		}
	}

	public void connect() {
		try (Jedis jedis = pool.getResource()) {
			jedis.connect();
		}
	}

	public void isConnected() {
		try (Jedis jedis = pool.getResource()) {
			jedis.isConnected();
		}
	}

	public void resetState() {
		try (Jedis jedis = pool.getResource()) {
			jedis.resetState();
		}
	}

	public void getDB() {
		try (Jedis jedis = pool.getResource()) {
			jedis.getDB();
		}
	}

	public void waitReplicas(int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			jedis.waitReplicas(ordinal, ordinal);
		}
	}

	public void disconnect() {
		try (Jedis jedis = pool.getResource()) {
			jedis.disconnect();
		}
	}

	public void getClient() {
		try (Jedis jedis = pool.getResource()) {
			jedis.getClient();
		}
	}

	public void randomBinaryKey() {
		try (Jedis jedis = pool.getResource()) {
			jedis.randomBinaryKey();
		}
	}

}
