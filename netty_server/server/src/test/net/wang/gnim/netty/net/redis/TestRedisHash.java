package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisHash;

public class TestRedisHash {
	@Test
	public void hset() {
		RedisHash.INSTANCE.hset(null, null);
	}

	@Test
	public void hget() {
		RedisHash.INSTANCE.hget(null, null);
	}

	@Test
	public void hsetnx() {
		RedisHash.INSTANCE.hsetnx(null, null);
	}

	@Test
	public void hmset() {
		RedisHash.INSTANCE.hmset(null, null);
	}

	@Test
	public void hmget() {
		RedisHash.INSTANCE.hmget(null, null);
	}

	@Test
	public void hincrBy() {
		RedisHash.INSTANCE.hincrBy(null, null, 0);
	}

	@Test
	public void hincrByFloat() {
		RedisHash.INSTANCE.hincrByFloat(null, null, 0);
	}

	@Test
	public void hexists() {
		RedisHash.INSTANCE.hexists(null, null);
	}

	@Test
	public void hdel() {
		RedisHash.INSTANCE.hdel(null, null);
	}

	@Test
	public void hlen() {
		RedisHash.INSTANCE.hlen(null);
	}

	@Test
	public void hkeys() {
		RedisHash.INSTANCE.hkeys(null);
	}

	@Test
	public void hvals() {
		RedisHash.INSTANCE.hvals(null);
	}

	@Test
	public void hgetAll() {
		RedisHash.INSTANCE.hgetAll(null);
	}

	@Test
	public void hscan() {
		RedisHash.INSTANCE.hscan(null, null);
	}
}
