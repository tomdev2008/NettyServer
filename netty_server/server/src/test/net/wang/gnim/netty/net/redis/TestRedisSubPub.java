package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisSubPub;

public class TestRedisSubPub {
	@Test
	public void publish() {
		RedisSubPub.INSTANCE.publish(null, null);
	}

	@Test
	public void pubsubNumPat() {
		RedisSubPub.INSTANCE.pubsubNumPat();
	}

	@Test
	public void pubsubNumSub() {
		RedisSubPub.INSTANCE.pubsubNumSub();
	}

	@Test
	public void psubscribe() {
		RedisSubPub.INSTANCE.psubscribe(null, null);
	}
}
