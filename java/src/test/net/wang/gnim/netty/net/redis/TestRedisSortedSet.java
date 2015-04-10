package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisSortedSet;

public class TestRedisSortedSet {
	@Test
	public void zrevrangeWithScores() {
		RedisSortedSet.INSTANCE.zrevrangeWithScores(null, null, 0);
	}

	@Test
	public void zrangeByScoreWithScores() {
		RedisSortedSet.INSTANCE.zrangeByScoreWithScores(null, null);
	}

	@Test
	public void zrevrangeByScore() {
		RedisSortedSet.INSTANCE.zrevrangeByScore(null, null);
	}

	@Test
	public void zrevrangeByScoreWithScores() {
		RedisSortedSet.INSTANCE.zrevrangeByScoreWithScores(null, null);
	}

	@Test
	public void zremrangeByRank() {
		RedisSortedSet.INSTANCE.zremrangeByRank(0, null);
	}

	@Test
	public void zrangeWithScores() {
		RedisSortedSet.INSTANCE.zrangeWithScores(0, null);
	}

	@Test
	public void zadd() {
		RedisSortedSet.INSTANCE.zadd(null, null);
	}

	@Test
	public void zrange() {
		RedisSortedSet.INSTANCE.zrange(null, null);
	}

	@Test
	public void zrem() {
		RedisSortedSet.INSTANCE.zrem(null, null);
	}

	@Test
	public void zincrby() {
		RedisSortedSet.INSTANCE.zincrby(null, 0, null);
	}

	@Test
	public void zrank() {
		RedisSortedSet.INSTANCE.zrank(null, null);
	}

	@Test
	public void zrevrank() {
		RedisSortedSet.INSTANCE.zrevrank(null, null);
	}

	@Test
	public void zrevrange() {
		RedisSortedSet.INSTANCE.zrevrange(null, null, 0);
	}

	@Test
	public void zcard() {
		RedisSortedSet.INSTANCE.zcard(null, null);
	}

	@Test
	public void zscore() {
		RedisSortedSet.INSTANCE.zscore(null, null);
	}

	@Test
	public void zcount() {
		RedisSortedSet.INSTANCE.zcount(null, null);
	}

	@Test
	public void zrangeByScore() {
		RedisSortedSet.INSTANCE.zrangeByScore(null, null);
	}

	@Test
	public void zunionstore() {
		RedisSortedSet.INSTANCE.zunionstore(null, null);
	}

	@Test
	public void zinterstore() {
		RedisSortedSet.INSTANCE.zinterstore(null, null);
	}

	@Test
	public void zlexcount() {
		RedisSortedSet.INSTANCE.zlexcount(null, null);
	}

	@Test
	public void zrangeByLex() {
		RedisSortedSet.INSTANCE.zrangeByLex(null, null);
	}

	@Test
	public void zscan() {
		RedisSortedSet.INSTANCE.zscan(null, null);
	}

	@Test
	public void zremrangeByScore() {
		RedisSortedSet.INSTANCE.zremrangeByScore(null, null);
	}

	@Test
	public void zremrangeByLex() {
		RedisSortedSet.INSTANCE.zremrangeByLex(null, null);
	}
}
