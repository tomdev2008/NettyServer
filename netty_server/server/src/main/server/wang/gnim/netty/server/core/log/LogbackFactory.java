package wang.gnim.netty.server.core.log;

import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

public enum LogbackFactory {

	CLIENT("src/main/resource/logback_client.xml"),
	
	SERVER("src/main/resource/logback_server.xml");
	
	
	LogbackFactory(String fileName) {
		this.fileName = fileName;
	}
	
	private String fileName;
	
	private boolean isInit = false;
	
	public synchronized void init() {
		
		if(isInit == true)
			throw new RuntimeException("LogbackFactory had init~~~");
		
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			File externalConfigFile = new File(fileName);
			if (!externalConfigFile.exists()) {

				throw new IOException(
						"logback server file : " + fileName + " not existed!!!");

			}
			if (!externalConfigFile.isFile()) {
				throw new IOException(
						"logback server file : " + fileName + " not file!!!");
			}
			if (!externalConfigFile.canRead()) {
				throw new IOException(
						"logback server file : " + fileName + " can't read!!!");
			}
			
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(lc);
			lc.reset();
			configurator.doConfigure(fileName);
			StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		isInit = true;
	}
}
