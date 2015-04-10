package wang.gnim.netty.server.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wang.gnim.netty.server.core.log.LogbackFactory;

/**
 * 只会读取logback.xml文件配置并生成相应的日志文件
 * 
 * @author wangming
 *
 */
public class Slf4jServer {
	
	public static void main(String[] args) {
		LogbackFactory.SERVER.init();;
		
		Logger logger = LoggerFactory.getLogger(Slf4jServer.class);
		
		System.out.println("Slf4jServer start!!!");
	}
}
