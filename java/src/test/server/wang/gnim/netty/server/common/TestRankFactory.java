package wang.gnim.netty.server.common;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import wang.gnim.netty.server.common.RankFactory;

public class TestRankFactory {

	@Test
	public void test() {
		RankFactory<RankObject> rf = RankFactory.newRankFactory();
		
//		for(int i = 0; i< 100; i++) {
//			int id = ThreadLocalRandom.current().nextInt(100);
//			RankObject obj = new RankObject();
//			obj.id = id;
//			rf.add(obj);
//		}
//		
//		System.out.println("count : " + rf.getAll().size());
//		for (RankObject obj : rf.getAll()) {
//			System.out.println(obj.id);
//		}
	}
	
	public static class RankObject implements Comparable<RankObject> {

		int id;
		
		@Override
		public int compareTo(RankObject o) {
			if(o.id > this.id)
				return 1;
			else if(o.id < this.id)
				return -1;
			
			return 0;
		}
		
	}
}
