package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisClient;

public class TestRedisClient {
	@Test
	public void connect() {
		RedisClient.INSTANCE.connect();
	}

	@Test
	public void close() {
		RedisClient.INSTANCE.close(null);
	}

	@Test
	public void randomBinaryKey() {
		RedisClient.INSTANCE.randomBinaryKey();
	}

	@Test
	public void setDataSource() {
		RedisClient.INSTANCE.setDataSource();
	}

	@Test
	public void resetState() {
		RedisClient.INSTANCE.resetState();
	}

	@Test
	public void getDB() {
		RedisClient.INSTANCE.getDB();
	}

	@Test
	public void isConnected() {
		RedisClient.INSTANCE.isConnected();
	}

	@Test
	public void disconnect() {
		RedisClient.INSTANCE.disconnect();
	}

	@Test
	public void getClient() {
		RedisClient.INSTANCE.getClient();
	}

	@Test
	public void bitpos() {
		RedisClient.INSTANCE.bitpos(null, false);
	}

	@Test
	public void sentinelReset() {
		RedisClient.INSTANCE.sentinelReset(null);
	}

	@Test
	public void sentinelSet() {
		RedisClient.INSTANCE.sentinelSet(null);
	}

	@Test
	public void asking() {
		RedisClient.INSTANCE.asking();
	}

	@Test
	public void expireAt() {
		RedisClient.INSTANCE.expireAt(null, 0);
	}

	@Test
	public void substr() {
		RedisClient.INSTANCE.substr("");
	}

	@Test
	public void sunionstore() {
		RedisClient.INSTANCE.sunionstore(null, null);
	}

	@Test
	public void waitReplicas() {
		RedisClient.INSTANCE.waitReplicas(0);
	}
}
