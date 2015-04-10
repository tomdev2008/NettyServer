package wang.gnim.netty.net.netty.handlers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;


import org.apache.log4j.Logger;

import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Netty默认的Reactor模型只有MainReactor和SubReactor.
 * ChannelHandler链的执行过程是在 SubReactor(workerGroup)中同步执行的,
 * 所以如果业务处理handler耗时长,将严重影响可支持的并发数.这种模型适合于像Memcache这样的应用场景,
 * 但 对需要操作数据库或者和其他模块阻塞交互的系统就不是很合适.
 * 
 * 当ChannelHandler需要线程池化的时候,可以通过在 ChannelPipeline中添加Netty内置的ChannelHandler实现类–ExecutionHandler实现.
 * 对于ExecutionHandler需要的线程池模型,Netty提供了两种可 选：
 * 1） MemoryAwareThreadPoolExecutor 可控制Executor中待处理任务的上限（超过上限时,后续进来的任务将被阻 塞）,并可控制单个Channel待处理任务的上限；
 * 2） OrderedMemoryAwareThreadPoolExecutor 是  MemoryAwareThreadPoolExecutor 的子类,它还可以保证同一Channel中处理的事件流的顺序性,
 *     这主要是控制事件在异步处 理模式下可能出现的错误的事件顺序,但它并不保证同一Channel中的事件都在一个线程中执行（通常也没必要）
 * 
 */
public class ExecutorHandler extends ChannelInboundHandlerAdapter  {

//	private static final Logger logger = Logger.getLogger(ExecutorHandler.class);
//	
//	// TODO 考虑使用何种阻塞队列
//	private final BlockingQueue<EvevntMessage> msgs = new LinkedTransferQueue<>();
//	// TODO 考虑使用何种线程池
//	private final ExecutorService pool = Executors.newCachedThreadPool();
//	
//	public ExecutorHandler () {
//		
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					while(true) {
//						EvevntMessage event = msgs.take();
//						pool.execute(new RouterRunnable(event));
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		thread.start();
//	}
//	
//	public void route (EvevntMessage message) {
//		try {
//			
//			msgs.put(message);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static class RouterRunnable implements Runnable {
//
//		EvevntMessage event;
//		
//		RouterRunnable(EvevntMessage message) {
//			this.event = message;
//		}
//		
//		@Override
//		public void run() {
//			ParseFactory.parse(event);
//		}
//		
//	}
}
