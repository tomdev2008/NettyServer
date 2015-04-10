package wang.gnim.netty.server.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wang.gnim.netty.server.core.log.LogbackFactory;

public class Slf4jClient {

	public static void main(String[] args) {
		LogbackFactory.CLIENT.init();
		
		Logger mLogger = LoggerFactory.getLogger("logger.SocketAppenderM");
		for (int i = 0; i < 1; i++)
			mLogger.info("--------SocketAppenderM");

		Logger nLogger = LoggerFactory.getLogger("logger.SocketAppenderN");
		for (int i = 0; i < 1; i++)
			nLogger.info("--------SocketAppenderN");

		Logger mongoLogger = LoggerFactory.getLogger("logger.MongonDBAppender");
		for (int i = 0; i < 1; i++)
			mongoLogger.info("--------SocketAppenderN");

	}

}
