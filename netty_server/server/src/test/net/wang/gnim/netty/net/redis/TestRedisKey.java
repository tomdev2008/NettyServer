package wang.gnim.netty.net.redis;

import junit.framework.Assert;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisKey;

public class TestRedisKey {
	@Test
	public void type() {
		RedisKey.INSTANCE.type(null);
	}

	@Test
	public void keys() {
		RedisKey.INSTANCE.keys(null);
	}

	@Test
	public void exists() {
		RedisKey.INSTANCE.exists(null);
	}

	@Test
	public void sort() {
		RedisKey.INSTANCE.sort(null, null);
	}

	@Test
	public void rename() {
		RedisKey.INSTANCE.rename(null, null);
	}

	@Test
	public void move() {
		RedisKey.INSTANCE.move(null, 0);
	}

	@Test
	public void scan() {
		RedisKey.INSTANCE.scan(null);
	}

	@Test
	public void del() {
		Long d123 = RedisKey.INSTANCE.del("123");
		Assert.assertEquals(0l, (long)d123);
		
		
	}

	@Test
	public void randomKey() {
		String random = RedisKey.INSTANCE.randomKey();
		System.out.println("randomKey : " + random);
	}

	@Test
	public void renamenx() {
		RedisKey.INSTANCE.renamenx(null, null);
	}

	@Test
	public void expire() {
		RedisKey.INSTANCE.expire(null, 0);
	}

	@Test
	public void ttl() {
		RedisKey.INSTANCE.ttl(null, null);
	}

	@Test
	public void persist() {
		RedisKey.INSTANCE.persist(null, null);
	}

	@Test
	public void dump() {
		RedisKey.INSTANCE.dump(null);
	}

	@Test
	public void restore() {
		RedisKey.INSTANCE.restore(null, 0, null);
	}

	@Test
	public void pexpireAt() {
		RedisKey.INSTANCE.pexpireAt(null, 0);
	}

	@Test
	public void pttl() {
		RedisKey.INSTANCE.pttl(null, null);
	}

	@Test
	public void migrate() {
		RedisKey.INSTANCE.migrate(null, null, 0);
	}

	@Test
	public void objectRefcount() {
		RedisKey.INSTANCE.objectRefcount(null);
	}

	@Test
	public void objectEncoding() {
		RedisKey.INSTANCE.objectEncoding(null);
	}

	@Test
	public void objectIdletime() {
		RedisKey.INSTANCE.objectIdletime(null);
	}
}
