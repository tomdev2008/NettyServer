package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisSet;

public class TestRedisSet {
	@Test
	public void sadd() {
		RedisSet.INSTANCE.sadd(null, null);
	}

	@Test
	public void smembers() {
		RedisSet.INSTANCE.smembers(null);
	}

	@Test
	public void srem() {
		RedisSet.INSTANCE.srem(null, null);
	}

	@Test
	public void spop() {
		RedisSet.INSTANCE.spop(null);
	}

	@Test
	public void smove() {
		RedisSet.INSTANCE.smove(null, null);
	}

	@Test
	public void scard() {
		RedisSet.INSTANCE.scard(null);
	}

	@Test
	public void sismember() {
		RedisSet.INSTANCE.sismember(null, null);
	}

	@Test
	public void sinter() {
		RedisSet.INSTANCE.sinter(null, null);
	}

	@Test
	public void sinterstore() {
		RedisSet.INSTANCE.sinterstore(null, null);
	}

	@Test
	public void sunion() {
		RedisSet.INSTANCE.sunion(null, null);
	}

	@Test
	public void sdiff() {
		RedisSet.INSTANCE.sdiff(null, null);
	}

	@Test
	public void sdiffstore() {
		RedisSet.INSTANCE.sdiffstore(null, null);
	}

	@Test
	public void srandmember() {
		RedisSet.INSTANCE.srandmember(null);
	}

	@Test
	public void sscan() {
		RedisSet.INSTANCE.sscan(null, null);
	}
}
