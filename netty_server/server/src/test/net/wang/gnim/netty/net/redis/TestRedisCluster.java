package wang.gnim.netty.net.redis;

import org.junit.Test;

import wang.gnim.netty.net.redis.RedisCluster;

public class TestRedisCluster {
	
	@Test
	public void clusterSlots() {
		RedisCluster.INSTANCE.clusterSlots();
	}

	@Test
	public void clusterNodes() {
		RedisCluster.INSTANCE.clusterNodes();
	}

	@Test
	public void clusterMeet() {
		RedisCluster.INSTANCE.clusterMeet(0, null);
	}

	@Test
	public void clusterReset() {
		RedisCluster.INSTANCE.clusterReset(null);
	}

	@Test
	public void clusterInfo() {
		RedisCluster.INSTANCE.clusterInfo();
	}

	@Test
	public void clusterForget() {
		RedisCluster.INSTANCE.clusterForget(null);
	}

	@Test
	public void clusterSlaves() {
		RedisCluster.INSTANCE.clusterSlaves(null);
	}

	@Test
	public void clusterAddSlots() {
		RedisCluster.INSTANCE.clusterAddSlots(null, null);
	}

	@Test
	public void clusterDelSlots() {
		RedisCluster.INSTANCE.clusterDelSlots();
	}

	@Test
	public void clusterGetKeysInSlot() {
		RedisCluster.INSTANCE.clusterGetKeysInSlot(0);
	}

	@Test
	public void clusterSetSlotNode() {
		RedisCluster.INSTANCE.clusterSetSlotNode(0, null);
	}

	@Test
	public void clusterSetSlotMigrating() {
		RedisCluster.INSTANCE.clusterSetSlotMigrating(0, null);
	}

	@Test
	public void clusterSetSlotImporting() {
		RedisCluster.INSTANCE.clusterSetSlotImporting(0, null);
	}

	@Test
	public void clusterSetSlotStable() {
		RedisCluster.INSTANCE.clusterSetSlotStable(0);
	}

	@Test
	public void clusterFlushSlots() {
		RedisCluster.INSTANCE.clusterFlushSlots();
	}

	@Test
	public void clusterKeySlot() {
		RedisCluster.INSTANCE.clusterKeySlot(null);
	}

	@Test
	public void clusterCountKeysInSlot() {
		RedisCluster.INSTANCE.clusterCountKeysInSlot(0);
	}

	@Test
	public void clusterSaveConfig() {
		RedisCluster.INSTANCE.clusterSaveConfig();
	}

	@Test
	public void clusterReplicate() {
		RedisCluster.INSTANCE.clusterReplicate(null);
	}

	@Test
	public void clusterFailover() {
		RedisCluster.INSTANCE.clusterFailover();
	}
}
