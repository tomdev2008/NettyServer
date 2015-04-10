package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisTransaction;

public class TestRedisTransaction {
	@Test
	public void unwatch() {
		RedisTransaction.INSTANCE.unwatch();
	}

	@Test
	public void watch() {
		RedisTransaction.INSTANCE.watch(null, null);
	}
}
