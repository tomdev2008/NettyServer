package wang.gnim.netty.server.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import wang.gnim.netty.server.common.IDFactory;

public class TestIDFactory {

	@Test
	@Ignore
	public void test() {
		long id = IDFactory.test.get();
		Assert.assertEquals(10001, id);
	}
	
	@Test
	@Ignore
	public void testIncrease() {
		long id = IDFactory.test.increase();
		Assert.assertEquals(20002, id);
	}
	
	@Test
	@Ignore
	public void printLongMaxValue() {
		System.out.println(Long.MAX_VALUE);
	}
	
	@Test
	public void testMutilIncrease() {
		Runnable t = new Runnable() {
			
			@Override
			public void run() {
				int rand = ThreadLocalRandom.current().nextInt(5);
				try {
					TimeUnit.SECONDS.sleep(rand);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				IDFactory.test.increase();
			}
		};
		
		List<Thread> list = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			Thread ta = new Thread(t);
			ta.start();
			list.add(ta);
		}
		
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long id = IDFactory.test.get();
		Assert.assertEquals(100010001, id);
	}
	
	// 测试testMutilIncrease 的并发环境模拟是正确的
	@Test
	public void testMockMutilIncrease() {
		Runnable t = new Runnable() {
			
			@Override
			public void run() {
				int rand = ThreadLocalRandom.current().nextInt(5);
				try {
					TimeUnit.SECONDS.sleep(rand);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				MockIDFactory.test.increase();
			}
		};
		
		List<Thread> list = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			Thread ta = new Thread(t);
			ta.start();
			list.add(ta);
		}
		
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long id = MockIDFactory.test.get();
		Assert.assertTrue(10000 != id);
	}
	
	public enum MockIDFactory {

		test("test");
		
		private long id = 0;
		
		/**
		 * 找到数据库里最大的值,作为初始ID
		 * 
		 * @param tableName 数据库表名
		 */
		MockIDFactory(String tableName) {
		}
		
		public long increase() {
			return ++id;
		}
		
		public long get() {
			return id;
		}
	}

}
