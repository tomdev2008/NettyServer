package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisScript;

public class TestRedisScript {
	@Test
	public void scriptFlush() {
		RedisScript.INSTANCE.scriptFlush();
	}

	@Test
	public void scriptKill() {
		RedisScript.INSTANCE.scriptKill();
	}

	@Test
	public void eval() {
		RedisScript.INSTANCE.eval(null);
	}

	@Test
	public void evalsha() {
		RedisScript.INSTANCE.evalsha(null);
	}

	@Test
	public void scriptExists() {
		RedisScript.INSTANCE.scriptExists(null, null);
	}

	@Test
	public void scriptLoad() {
		RedisScript.INSTANCE.scriptLoad(null);
	}
}
