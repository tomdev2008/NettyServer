package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisString;

public class TestRedisString {
	@Test
	public void get() {
//		RedisString.INSTANCE.get(null);
	}

	@Test
	public void get1() {
//		RedisString.INSTANCE.get(null);
	}

	@Test
	public void append() {
		RedisString.INSTANCE.append(null, null);
	}

	@Test
	public void set() {
//		RedisString.INSTANCE.set(null, null);
	}

	@Test
	public void set2() {
//		RedisString.INSTANCE.set(null, null);
	}

	@Test
	public void getSet() {
		RedisString.INSTANCE.getSet(null, null);
	}

	@Test
	public void mget() {
		RedisString.INSTANCE.mget(null, null);
	}

	@Test
	public void setnx() {
		RedisString.INSTANCE.setnx(null, null);
	}

	@Test
	public void setex() {
		RedisString.INSTANCE.setex(null, 0, null);
	}

	@Test
	public void mset() {
		RedisString.INSTANCE.mset(null, null);
	}

	@Test
	public void msetnx() {
		RedisString.INSTANCE.msetnx(null, null);
	}

	@Test
	public void decrBy() {
		RedisString.INSTANCE.decrBy(null, 0);
	}

	@Test
	public void decr() {
		RedisString.INSTANCE.decr(null);
	}

	@Test
	public void incrBy() {
		RedisString.INSTANCE.incrBy(null, 0);
	}

	@Test
	public void incrByFloat() {
		RedisString.INSTANCE.incrByFloat(null, 0);
	}

	@Test
	public void incr() {
		RedisString.INSTANCE.incr(null);
	}

	@Test
	public void strlen() {
		RedisString.INSTANCE.strlen(null);
	}

	@Test
	public void setbit() {
		RedisString.INSTANCE.setbit(null, null, 0);
	}

	@Test
	public void getbit() {
		RedisString.INSTANCE.getbit(null, 0);
	}

	@Test
	public void setrange() {
		RedisString.INSTANCE.setrange(null, null, 0);
	}

	@Test
	public void getrange() {
		RedisString.INSTANCE.getrange(null, 0);
	}

	@Test
	public void bitcount() {
		RedisString.INSTANCE.bitcount(null, null);
	}

	@Test
	public void bitop() {
		RedisString.INSTANCE.bitop(null);
	}

	@Test
	public void psetex() {
		RedisString.INSTANCE.psetex(null, null, 0);
	}
}
