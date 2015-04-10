package wang.gnim.netty.net.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public enum RedisCluster {

	INSTANCE;
	
	private JedisPool pool;

	RedisCluster() {
		pool = new JedisPool("10.234.10.12", 7006);
	}
	
	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotMigrating(int ordinal, String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSetSlotMigrating(ordinal, name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotImporting(int ordinal, String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSetSlotImporting(ordinal, name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public String clusterSetSlotStable(int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSetSlotStable(ordinal);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterFlushSlots() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterFlushSlots();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Long clusterKeySlot(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterKeySlot(name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public Long clusterCountKeysInSlot(int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterCountKeysInSlot(ordinal);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterSaveConfig() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSaveConfig();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String clusterReplicate(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterReplicate(name);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterFailover() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterFailover();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String clusterNodes() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterNodes();
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterMeet(int ordinal, String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterMeet(name, ordinal);
		}
	}

	/**
	 * 
	 * @param reset
	 * @return
	 */
	public String clusterReset(JedisCluster.Reset reset) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterReset(reset);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterInfo() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterInfo();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String clusterForget(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterForget(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<String> clusterSlaves(String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSlaves(name);
		}
	}

	/**
	 * 
	 */
	public void clusterSlots() {
		try (Jedis jedis = pool.getResource()) {
			jedis.clusterSlots();
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String clusterAddSlots(String key, String value) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterAddSlots();
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterDelSlots() {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterDelSlots();
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public List<String> clusterGetKeysInSlot(int ordinal) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterGetKeysInSlot(ordinal, ordinal);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotNode(int ordinal, String name) {
		try (Jedis jedis = pool.getResource()) {
			return jedis.clusterSetSlotNode(ordinal, name);
		}
	}
}
