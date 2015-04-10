package wang.gnim.netty.server.core.log.server;

import ch.qos.logback.classic.sift.SiftingAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class SimpleSiftingAppender extends SiftingAppender{

	@Override
	protected void append(ILoggingEvent event) {
		
		String suffixPattern = event.getMDCPropertyMap().get("suffixPattern");
		getContext().putProperty("suffixPattern", suffixPattern);
		
		super.append(event);
	}

	
}
