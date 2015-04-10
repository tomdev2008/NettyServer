package wang.gnim.netty.net.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public enum RedisServer {

	INSTANCE;
	
	private JedisPool pool;

	RedisServer() {
		pool = new JedisPool("10.234.10.12", 7006);
	}

	public void bgrewriteaof() {
		try (Jedis jedis = pool.getResource()) {
			jedis.bgrewriteaof();
		}
	}

	public void bgsave() {
		try (Jedis jedis = pool.getResource()) {
			jedis.bgsave();
		}
	}

	public void clientKill(String key) {
		try (Jedis jedis = pool.getResource()) {
			jedis.clientKill(key);
		}
	}

	public void clientSetname(String key) {
		try (Jedis jedis = pool.getResource()) {
			jedis.clientSetname(key);
		}
	}

	public void clientGetname() {
		try (Jedis jedis = pool.getResource()) {
			jedis.clientGetname();
		}
	}

	public void clientList() {
		try (Jedis jedis = pool.getResource()) {
			jedis.clientList();
		}
	}

	public void configResetStat() {
		try (Jedis jedis = pool.getResource()) {
			jedis.configResetStat();
		}
	}

	public void configGet(String key) {
		try (Jedis jedis = pool.getResource()) {
			jedis.configGet(key);
		}
	}

	public void configSet(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			jedis.configSet(key, value);
		}
	}

	public void dbSize() {
		try (Jedis jedis = pool.getResource()) {
			jedis.dbSize();
		}
	}

	public void flushDB() {
		try (Jedis jedis = pool.getResource()) {
			jedis.flushDB();
		}
	}

	public void info() {
		try (Jedis jedis = pool.getResource()) {
			jedis.info();
		}
	}

	public void lastsave() {
		try (Jedis jedis = pool.getResource()) {
			jedis.lastsave();
		}
	}

	public void monitor() {
		try (Jedis jedis = pool.getResource()) {
			jedis.monitor(null);
		}
	}

	public void flushAll() {
		try (Jedis jedis = pool.getResource()) {
			jedis.flushAll();
		}
	}

	public void shutdown() {
		try (Jedis jedis = pool.getResource()) {
			jedis.shutdown();
		}
	}

	public void debug() {
		try (Jedis jedis = pool.getResource()) {
			jedis.debug(null);
		}
	}

	public void save() {
		try (Jedis jedis = pool.getResource()) {
			jedis.save();
		}
	}

	public void slaveof(String name, int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			jedis.slaveof(name, ordinal);
		}
	}

	public void slaveofNoOne() {
		try (Jedis jedis = pool.getResource()) {
			jedis.slaveofNoOne();
		}
	}

	public void slowlogGet() {
		try (Jedis jedis = pool.getResource()) {
			jedis.slowlogGet();
		}
	}

	public void slowlogReset() {
		try (Jedis jedis = pool.getResource()) {
			jedis.slowlogReset();
		}
	}

	public void slowlogLen() {
		try (Jedis jedis = pool.getResource()) {
			jedis.slowlogLen();
		}
	}

	public void slowlogGetBinary() {
		try (Jedis jedis = pool.getResource()) {
			jedis.slowlogGetBinary();
		}
	}

	public void sync() {
		try (Jedis jedis = pool.getResource()) {
			jedis.sync();
		}
	}

	public void time() {
		try (Jedis jedis = pool.getResource()) {
			jedis.time();
		}
	}

}
