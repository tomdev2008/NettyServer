package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisConnection;

public class TestRedisConnection {
	@Test
	public void select() {
		RedisConnection.INSTANCE.select(0);
	}

	@Test
	public void quit() {
		RedisConnection.INSTANCE.quit();
	}

	@Test
	public void auth() {
		RedisConnection.INSTANCE.auth(null);
	}

	@Test
	public void ping() {
		RedisConnection.INSTANCE.ping();
	}

	@Test
	public void echo() {
		RedisConnection.INSTANCE.echo(null);
	}
}
