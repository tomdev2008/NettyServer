package wang.gnim.netty.server.core.log.client;

import java.util.HashMap;

import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;

public class SimpleSocketAppender extends SocketAppender {


	private String stackTracePattern;
	private String suffixPattern;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void append(ILoggingEvent event) {
		LoggingEvent nv = (LoggingEvent)event;
		nv.setMDCPropertyMap(new HashMap<String, String>());
		event.getMDCPropertyMap().put("stackTracePattern", stackTracePattern);
		event.getMDCPropertyMap().put("suffixPattern", suffixPattern);
		
		super.append(event);
	}

	public String getStackTracePattern() {
		return stackTracePattern;
	}

	public void setStackTracePattern(String stackTracePattern) {
		this.stackTracePattern = stackTracePattern;
	}
	
	public String getSuffixPattern() {
		return suffixPattern;
	}

	public void setSuffixPattern(String suffixPattern) {
		this.suffixPattern = suffixPattern;
	}

	@Override
	protected void postProcessEvent(ILoggingEvent event) {
		for (String key : event.getMDCPropertyMap().keySet()) {
			System.out.println("post   Name(" + getName() + ").  LoggerName(" + event.getLoggerName() + ").  key(" + key + ").  value(" + event.getMDCPropertyMap().get(key) + ").  message(" + event.getMessage()+")");
		}
	};
	
}
