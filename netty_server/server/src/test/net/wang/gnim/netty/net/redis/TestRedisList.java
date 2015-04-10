package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisList;

public class TestRedisList {
	@Test
	public void rpush() {
		RedisList.INSTANCE.rpush(null, null);
	}

	@Test
	public void lpush() {
		RedisList.INSTANCE.lpush(null, null);
	}

	@Test
	public void llen() {
		RedisList.INSTANCE.llen(null);
	}

	@Test
	public void lrange() {
		RedisList.INSTANCE.lrange(0, null);
	}

	@Test
	public void ltrim() {
		RedisList.INSTANCE.ltrim(null, null, 0);
	}

	@Test
	public void lindex() {
		RedisList.INSTANCE.lindex(null, 0);
	}

	@Test
	public void lset() {
		RedisList.INSTANCE.lset(null, 0, null);
	}

	@Test
	public void lrem() {
		RedisList.INSTANCE.lrem(null, 0, null);
	}

	@Test
	public void lpop() {
		RedisList.INSTANCE.lpop(null);
	}

	@Test
	public void rpop() {
		RedisList.INSTANCE.rpop(null);
	}

	@Test
	public void rpoplpush() {
		RedisList.INSTANCE.rpoplpush(null, null);
	}

	@Test
	public void blpop() {
		RedisList.INSTANCE.blpop(null, null);
	}

	@Test
	public void brpop() {
		RedisList.INSTANCE.brpop(null, null);
	}

	@Test
	public void lpushx() {
		RedisList.INSTANCE.lpushx(null, null);
	}

	@Test
	public void rpushx() {
		RedisList.INSTANCE.rpushx(null, null);
	}

	@Test
	public void linsert() {
		RedisList.INSTANCE.linsert(null, null);
	}

	@Test
	public void brpoplpush() {
		RedisList.INSTANCE.brpoplpush(null, null, 0);
	}
}
