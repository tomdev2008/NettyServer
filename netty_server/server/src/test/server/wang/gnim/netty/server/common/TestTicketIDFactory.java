package wang.gnim.netty.server.common;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import wang.gnim.netty.server.common.TicketIDFactory;

public class TestTicketIDFactory {

	@Test
	@Ignore
	public void testA() {
		long id = TicketIDFactory.A.get64ID();
		System.out.println("A:" + id);
	}
	
	@Test
	@Ignore
	public void testB() {
		long id = TicketIDFactory.B.get64ID();
		System.out.println("B:" + id);
	}
	
	@Test
	public void test1000Threads() {
		Runnable t = new Runnable() {
			
			@Override
			public void run() {
				TicketIDFactory.B.get64ID();
			}
		};
		
		List<Thread> list = new ArrayList<>();
		for(int i = 1; i < 10000; i++) {
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
		long id = TicketIDFactory.B.get64ID();
		System.out.println(id);
	}
}
