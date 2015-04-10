package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisServer;

public class TestRedisServer {
	@Test
	public void shutdown() {
		RedisServer.INSTANCE.shutdown();
	}

	@Test
	public void debug() {
		RedisServer.INSTANCE.debug();
	}

	@Test
	public void save() {
		RedisServer.INSTANCE.save();
	}

	@Test
	public void sync() {
		RedisServer.INSTANCE.sync();
	}

	@Test
	public void time() {
		RedisServer.INSTANCE.time();
	}

	@Test
	public void info() {
		RedisServer.INSTANCE.info();
	}

	@Test
	public void monitor() {
		RedisServer.INSTANCE.monitor();
	}

	@Test
	public void slowlogReset() {
		RedisServer.INSTANCE.slowlogReset();
	}

	@Test
	public void slowlogLen() {
		RedisServer.INSTANCE.slowlogLen();
	}

	@Test
	public void flushDB() {
		RedisServer.INSTANCE.flushDB();
	}

	@Test
	public void dbSize() {
		RedisServer.INSTANCE.dbSize();
	}

	@Test
	public void flushAll() {
		RedisServer.INSTANCE.flushAll();
	}

	@Test
	public void bgsave() {
		RedisServer.INSTANCE.bgsave();
	}

	@Test
	public void bgrewriteaof() {
		RedisServer.INSTANCE.bgrewriteaof();
	}

	@Test
	public void lastsave() {
		RedisServer.INSTANCE.lastsave();
	}

	@Test
	public void slaveof() {
		RedisServer.INSTANCE.slaveof(null, 0);
	}

	@Test
	public void slaveofNoOne() {
		RedisServer.INSTANCE.slaveofNoOne();
	}

	@Test
	public void clientGetname() {
		RedisServer.INSTANCE.clientGetname();
	}

	@Test
	public void clientList() {
		RedisServer.INSTANCE.clientList();
	}

	@Test
	public void slowlogGetBinary() {
		RedisServer.INSTANCE.slowlogGetBinary();
	}

	@Test
	public void clientSetname() {
		RedisServer.INSTANCE.clientSetname(null);
	}

	@Test
	public void configGet() {
		RedisServer.INSTANCE.configGet(null);
	}

	@Test
	public void configSet() {
		RedisServer.INSTANCE.configSet(null, null);
	}

	@Test
	public void slowlogGet() {
		RedisServer.INSTANCE.slowlogGet();
	}

	@Test
	public void clientKill() {
		RedisServer.INSTANCE.clientKill(null);
	}

	@Test
	public void configResetStat() {
		RedisServer.INSTANCE.configResetStat();
	}
}
