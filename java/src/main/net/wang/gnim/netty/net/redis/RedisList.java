package wang.gnim.netty.net.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public enum RedisList {

	INSTANCE;
	
	/**
	 * BLPOP 是列表的阻塞式(blocking)弹出原语.
	 * 
	 * 它是 LPOP 命令的阻塞版本,当给定列表内没有任何元素可供弹出的时候,连接将被 BLPOP 命令阻塞,直到等待超时或发现可弹出元素为止.
	 * 
	 * 当给定多个 key 参数时,按参数 key 的先后顺序依次检查各个列表,弹出第一个非空列表的头元素.
	 * 
	 * 非阻塞行为
	 * 
	 * 当 BLPOP 被调用时,如果给定 key
	 * 内至少有一个非空列表,那么弹出遇到的第一个非空列表的头元素,并和被弹出元素所属的列表的名字一起,组成结果返回给调用者.
	 * 
	 * 当存在多个给定 key 时, BLPOP 按给定 key 参数排列的先后顺序,依次检查各个列表.
	 * 
	 * 假设现在有 job 、 command 和 request 三个列表,其中 job 不存在, command 和 request
	 * 都持有非空列表.考虑以下命令：
	 * 
	 * BLPOP job command request 0
	 * 
	 * BLPOP 保证返回的元素来自 command ,因为它是按”查找 job -> 查找 command -> 查找 request
	 * “这样的顺序,第一个找到的非空列表.
	 * 
	 * 阻塞行为
	 * 
	 * 如果所有给定 key 都不存在或包含空列表,那么 BLPOP 命令将阻塞连接,直到等待超时,或有另一个客户端对给定 key 的任意一个执行
	 * LPUSH 或 RPUSH 命令为止.
	 * 
	 * 超时参数 timeout 接受一个以秒为单位的数字作为值.超时参数设为 0 表示阻塞时间可以无限期延长(block indefinitely) .
	 * 
	 * 相同的key被多个客户端同时阻塞
	 * 
	 * 相同的 key 可以被多个客户端同时阻塞.
	 * 
	 * 不同的客户端被放进一个队列中,按『先阻塞先服务』(first-BLPOP,first-served)的顺序为 key 执行 BLPOP 命令.
	 * 
	 * 在MULTI/EXEC事务中的BLPOP
	 * 
	 * BLPOP 可以用于流水线(pipline,批量地发送多个命令并读入多个回复),但把它用在 MULTI / EXEC
	 * 块当中没有意义.因为这要求整个服务器被阻塞以保证块执行时的原子性,该行为阻止了其他客户端执行 LPUSH 或 RPUSH 命令.
	 * 
	 * 因此,一个被包裹在 MULTI / EXEC 块内的 BLPOP 命令,行为表现得就像 LPOP 一样,对空列表返回 nil
	 * ,对非空列表弹出列表元素,不进行任何阻塞操作.
	 * 
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 如果列表为空,返回一个 nil . 否则,返回一个含有两个元素的列表,第一个元素是被弹出元素所属的 key
	 *         ,第二个元素是被弹出元素的值.
	 */
	public List<String> blpop(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.blpop(key, value);
		}
	}

	/**
	 * BRPOP 是列表的阻塞式(blocking)弹出原语.
	 * 
	 * 它是 RPOP 命令的阻塞版本,当给定列表内没有任何元素可供弹出的时候,连接将被 BRPOP 命令阻塞,直到等待超时或发现可弹出元素为止.
	 * 
	 * 当给定多个 key 参数时,按参数 key 的先后顺序依次检查各个列表,弹出第一个非空列表的尾部元素.
	 * 
	 * 关于阻塞操作的更多信息,请查看 BLPOP 命令, BRPOP 除了弹出元素的位置和 BLPOP 不同之外,其他表现一致.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 假如在指定时间内没有任何元素被弹出,则返回一个 nil 和等待时长.
	 *         反之,返回一个含有两个元素的列表,第一个元素是被弹出元素所属的 key ,第二个元素是被弹出元素的值.
	 */
	public List<String> brpop(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.brpop(key, value);
		}
	}

	/**
	 * BRPOPLPUSH 是 RPOPLPUSH 的阻塞版本,当给定列表 source 不为空时, BRPOPLPUSH 的表现和 RPOPLPUSH
	 * 一样.
	 * 
	 * 当列表 source 为空时, BRPOPLPUSH 命令将阻塞连接,直到等待超时,或有另一个客户端对 source 执行 LPUSH 或
	 * RPUSH 命令为止.
	 * 
	 * 超时参数 timeout 接受一个以秒为单位的数字作为值.超时参数设为 0 表示阻塞时间可以无限期延长(block indefinitely) .
	 * 
	 * 更多相关信息,请参考 RPOPLPUSH 命令.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 假如在指定时间内没有任何元素被弹出,则返回一个 nil 和等待时长.
	 *         反之,返回一个含有两个元素的列表,第一个元素是被弹出元素的值,第二个元素是等待时长.
	 */
	public String brpoplpush(String key, String value, int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.brpoplpush(key, value, ordinal);
		}
	}

	/**
	 * 将一个或多个值 value 插入到列表 key 的表头
	 * 
	 * 如果有多个 value 值,那么各个 value 值按从左到右的顺序依次插入到表头： 比如说,对空列表 mylist 执行命令 LPUSH
	 * mylist a b c ,列表的值将是 c b a ,这等同于原子性地执行 LPUSH mylist a 、 LPUSH mylist b 和
	 * LPUSH mylist c 三个命令.
	 * 
	 * 如果 key 不存在,一个空列表会被创建并执行 LPUSH 操作.
	 * 
	 * 当 key 存在但不是列表类型时,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 执行 LPUSH 命令后,列表的长度.
	 */
	public Long lpush(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lpush(key, value);
		}
	}

	/**
	 * 返回列表 key 的长度.
	 * 
	 * 如果 key 不存在,则 key 被解释为一个空列表,返回 0 .
	 * 
	 * 如果 key 不是列表类型,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 列表 key 的长度.
	 */
	public Long llen(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.llen(key);
		}
	}

	/**
	 * 返回列表 key 中指定区间内的元素,区间以偏移量 start 和 stop 指定.
	 * 
	 * 下标(index)参数 start 和 stop 都以 0 为底,也就是说,以 0 表示列表的第一个元素,以 1 表示列表的第二个元素,以此类推.
	 * 
	 * 你也可以使用负数下标,以 -1 表示列表的最后一个元素, -2 表示列表的倒数第二个元素,以此类推.
	 * 
	 * 注意LRANGE命令和编程语言区间函数的区别
	 * 
	 * 假如你有一个包含一百个元素的列表,对该列表执行 LRANGE list 0 10 ,结果是一个包含11个元素的列表,这表明 stop 下标也在
	 * LRANGE 命令的取值范围之内(闭区间),这和某些语言的区间函数可能不一致,比如Ruby的 Range.new 、 Array#slice
	 * 和Python的 range() 函数.
	 * 
	 * 超出范围的下标
	 * 
	 * 超出范围的下标值不会引起错误.
	 * 
	 * 如果 start 下标比列表的最大下标 end ( LLEN list 减去 1 )还要大,那么 LRANGE 返回一个空列表.
	 * 
	 * 如果 stop 下标比 end 下标还要大,Redis将 stop 的值设置为 end .
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 一个列表,包含指定区间内的元素.
	 */
	public List<String> lrange(long ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lrange(value, ordinal, ordinal);
		}
	}

	/**
	 * 对一个列表进行修剪(trim),就是说,让列表只保留指定区间内的元素,不在指定区间之内的元素都将被删除.
	 * 
	 * 举个例子,执行命令 LTRIM list 0 2 ,表示只保留列表 list 的前三个元素,其余元素全部删除.
	 * 
	 * 下标(index)参数 start 和 stop 都以 0 为底,也就是说,以 0 表示列表的第一个元素,以 1 表示列表的第二个元素,以此类推.
	 * 
	 * 你也可以使用负数下标,以 -1 表示列表的最后一个元素, -2 表示列表的倒数第二个元素,以此类推.
	 * 
	 * 当 key 不是列表类型时,返回一个错误.
	 * 
	 * LTRIM 命令通常和 LPUSH 命令或 RPUSH 命令配合使用,举个例子：
	 * 
	 * LPUSH log newest_log LTRIM log 0 99 这个例子模拟了一个日志程序,每次将最新日志 newest_log 放到
	 * log 列表中,并且只保留最新的 100 项.注意当这样使用 LTRIM 命令时,时间复杂度是O(1),因为平均情况下,每次只有一个元素被移除.
	 * 
	 * 注意LTRIM命令和编程语言区间函数的区别
	 * 
	 * 假如你有一个包含一百个元素的列表 list ,对该列表执行 LTRIM list 0 10 ,结果是一个包含11个元素的列表,这表明 stop
	 * 下标也在 LTRIM 命令的取值范围之内(闭区间),这和某些语言的区间函数可能不一致,比如Ruby的 Range.new 、
	 * Array#slice 和Python的 range() 函数.
	 * 
	 * 超出范围的下标
	 * 
	 * 超出范围的下标值不会引起错误.
	 * 
	 * 如果 start 下标比列表的最大下标 end ( LLEN list 减去 1 )还要大,或者 start > stop , LTRIM
	 * 返回一个空列表(因为 LTRIM 已经将整个列表清空).
	 * 
	 * 如果 stop 下标比 end 下标还要大,Redis将 stop 的值设置为 end .
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 命令执行成功时,返回 ok .
	 */
	public String ltrim(String key, String value, long ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.ltrim(key, ordinal, ordinal);
		}
	}

	/**
	 * 返回列表 key 中,下标为 index 的元素.
	 * 
	 * 下标(index)参数 start 和 stop 都以 0 为底,也就是说,以 0 表示列表的第一个元素,以 1 表示列表的第二个元素,以此类推.
	 * 
	 * 你也可以使用负数下标,以 -1 表示列表的最后一个元素, -2 表示列表的倒数第二个元素,以此类推.
	 * 
	 * 如果 key 不是列表类型,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 列表中下标为 index 的元素. 如果 index 参数的值不在列表的区间范围内(out of range),返回 nil .
	 */
	public String lindex(String key, long value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lindex(key, value);
		}
	}

	/**
	 * 将列表 key 下标为 index 的元素的值设置为 value .
	 * 
	 * 当 index 参数超出范围,或对一个空列表( key 不存在)进行 LSET 时,返回一个错误.
	 * 
	 * 关于列表下标的更多信息,请参考 LINDEX 命令.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 操作成功返回 ok ,否则返回错误信息.
	 */
	public String lset(String key, long ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lset(key, ordinal, value);
		}
	}

	/**
	 * 根据参数 count 的值,移除列表中与参数 value 相等的元素.
	 * 
	 * count 的值可以是以下几种：
	 * 
	 * count > 0 : 从表头开始向表尾搜索,移除与 value 相等的元素,数量为 count . count < 0 :
	 * 从表尾开始向表头搜索,移除与 value 相等的元素,数量为 count 的绝对值. count = 0 : 移除表中所有与 value
	 * 相等的值.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 被移除元素的数量. 因为不存在的 key 被视作空表(empty list),所以当 key 不存在时, LREM 命令总是返回
	 *         0 .
	 */
	public Long lrem(String key, long ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lrem(key, ordinal, value);
		}
	}

	/**
	 * 移除并返回列表 key 的头元素.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 列表的头元素. 当 key 不存在时,返回 nil .
	 */
	public String lpop(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lpop(key);
		}
	}

	/**
	 * 将值 value 插入到列表 key 的表尾,当且仅当 key 存在并且是一个列表.
	 * 
	 * 和 RPUSH 命令相反,当 key 不存在时, RPUSHX 命令什么也不做.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return RPUSHX 命令执行之后,表的长度.
	 */
	public Long rpushx(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.rpushx(key, value);
		}
	}

	/**
	 * 移除并返回列表 key 的尾元素.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 列表的尾元素. 当 key 不存在时,返回 nil
	 */
	public String rpop(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.rpop(key);
		}
	}

	/**
	 * 将一个或多个值 value 插入到列表 key 的表尾(最右边).
	 * 
	 * 如果有多个 value 值,那么各个 value 值按从左到右的顺序依次插入到表尾：比如对一个空列表 mylist 执行 RPUSH mylist
	 * a b c ,得出的结果列表为 a b c ,等同于执行命令 RPUSH mylist a 、 RPUSH mylist b 、 RPUSH
	 * mylist c .
	 * 
	 * 如果 key 不存在,一个空列表会被创建并执行 RPUSH 操作.
	 * 
	 * 当 key 存在但不是列表类型时,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 执行 RPUSH 操作后,表的长度.
	 */
	public Long rpush(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.rpush(key, value);
		}
	}

	/**
	 * 命令 RPOPLPUSH 在一个原子时间内,执行以下两个动作：
	 * 
	 * 将列表 source 中的最后一个元素(尾元素)弹出,并返回给客户端. 将 source 弹出的元素插入到列表 destination ,作为
	 * destination 列表的的头元素. 举个例子,你有两个列表 source 和 destination , source 列表有元素 a,
	 * b, c , destination 列表有元素 x, y, z ,执行 RPOPLPUSH source destination 之后,
	 * source 列表包含元素 a, b , destination 列表包含元素 c, x, y, z ,并且元素 c 会被返回给客户端.
	 * 
	 * 如果 source 不存在,值 nil 被返回,并且不执行其他动作.
	 * 
	 * 如果 source 和 destination
	 * 相同,则列表中的表尾元素被移动到表头,并返回该元素,可以把这种特殊情况视作列表的旋转(rotation)操作.
	 * @param key
	 * @param value
	 * @return 
	 * @return
	 */
	public String rpoplpush(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.rpoplpush(key, value);
		}
	}

	/**
	 * 
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 被弹出的元素.
	 */
	public Long lpushx(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.lpushx(key, value);
		}
	}

	/**
	 * 将值 value 插入到列表 key 当中,位于值 pivot 之前或之后.
	 * 
	 * 当 pivot 不存在于列表 key 时,不执行任何操作.
	 * 
	 * 当 key 不存在时, key 被视为空列表,不执行任何操作.
	 * 
	 * 如果 key 不是列表类型,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 
	 * @return 如果命令执行成功,返回插入操作完成之后,列表的长度. 如果没有找到 pivot ,返回 -1 . 如果 key
	 *         不存在或为空列表,返回 0 .
	 */
	public Long linsert(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.linsert(key, null, value, value);
		}
	}
}
