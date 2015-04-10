package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.HyperLogLog;


public class TestHyperLogLog {
	@Test
	public void pfcount() {
		HyperLogLog.INSTANCE.pfcount(null, null);
	}

	@Test
	public void pfadd() {
		HyperLogLog.INSTANCE.pfadd(null, null);
	}

	@Test
	public void pfmerge() {
		HyperLogLog.INSTANCE.pfmerge(null, null);
	}
}
