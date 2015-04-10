package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisSentinel;

public class TestRedisSentinel {
	@Test
	public void sentinelMasters() {
		RedisSentinel.INSTANCE.sentinelMasters();
	}

	@Test
	public void sentinelGetMasterAddrByName() {
		RedisSentinel.INSTANCE.sentinelGetMasterAddrByName(null);
	}

	@Test
	public void sentinelSlaves() {
		RedisSentinel.INSTANCE.sentinelSlaves(null);
	}

	@Test
	public void sentinelFailover() {
		RedisSentinel.INSTANCE.sentinelFailover(null);
	}

	@Test
	public void sentinelMonitor() {
		RedisSentinel.INSTANCE.sentinelMonitor(null, 0);
	}

	@Test
	public void sentinelRemove() {
		RedisSentinel.INSTANCE.sentinelRemove(null);
	}
}
