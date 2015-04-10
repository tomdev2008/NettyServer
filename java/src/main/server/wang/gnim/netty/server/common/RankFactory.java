package wang.gnim.netty.server.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.ImmutableList;

/**
 * 游戏当中的排行榜
 * 具有可并发,可排序,可重复,可索引,可延迟,排名变化 等特点
 * 
 * @author wangming
 *
 * @param <T>
 */
public class RankFactory<T> {

	public static <T> RankFactory<T> newRankFactory() {
		return new RankFactory<T>();
	}
	
	private final LinkedBlockingQueue<T> ele = new LinkedBlockingQueue<>();
	private final ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor)Executors.newSingleThreadExecutor();
	private final CloseRank<T> rank = new CloseRank<>();
	
	public void start() {
		exec.submit(new RankRunnable<>(ele, rank));
	}
	
	public void start(long delay, TimeUnit unit) {
		exec.schedule(new RankRunnable<>(ele, rank), delay, unit);
	}
	
	public void startAtFixedRate(long initialDelay, long period, TimeUnit unit) {
		exec.scheduleAtFixedRate(new RankRunnable<>(ele, rank), initialDelay, period, unit);
	}
	
	public void startWithFixedDelay(long initialDelay, long delay, TimeUnit unit) {
		exec.scheduleWithFixedDelay(new RankRunnable<>(ele, rank), initialDelay, delay, unit);
	}
	
	private static class CloseRank<T> {
		List<T> rank = new ArrayList<>();
	}
	
	private static class RankRunnable<T> implements Runnable {

		private LinkedBlockingQueue<T> ele;
		private List list = new ArrayList();
		private CloseRank<T> rank;
		
		public RankRunnable(LinkedBlockingQueue<T> ele, CloseRank<T> rank) {
			this.ele = ele;
			this.rank = rank;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					T el = ele.take();
					list.add(el);
					Collections.sort(list);
					rank.rank = ImmutableList.copyOf(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void add(T element) {
		ele.add(element);
	}
	
	
}
