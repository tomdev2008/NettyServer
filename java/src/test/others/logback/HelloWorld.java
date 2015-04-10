package logback;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

	@Test
	public void test2() {
		Logger logger = LoggerFactory.getLogger("Socket");
		for(int i =0; i < 10; i++)
			logger.debug("Hello world.");

	}
	
	@After
	@Ignore
	public void sleep() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
