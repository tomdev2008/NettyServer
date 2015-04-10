package wang.gnim.netty.server.core.log.server;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

public class SimpleFileAppender extends FileAppender<ILoggingEvent>{

	@Override
	protected void append(ILoggingEvent event) {
		
		String suffixPattern = event.getMDCPropertyMap().get("suffixPattern");
		getContext().putProperty("suffixPattern", suffixPattern);
		
		String stackTracePattern = event.getMDCPropertyMap().get("stackTracePattern");
		getContext().putProperty("stackTracePattern", stackTracePattern);
		
		
		super.append(event);
	}

}
