package wang.gnim.netty.server.core.log.client;

import org.bson.Document;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class MongoDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent>{

	private String remoteHost;
	private int port ;
	
	@Override
	public void doAppend(ILoggingEvent eventObject) {
		super.doAppend(eventObject);
	}
	
	@Override
	protected void append(ILoggingEvent eventObject) {

		System.out.println("append");
		Document doc = new Document();
		doc.append("info", eventObject.getMessage());
		
		MongoDBClient.CLIENT.insert("mydb", "c1", doc);
		
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
}
