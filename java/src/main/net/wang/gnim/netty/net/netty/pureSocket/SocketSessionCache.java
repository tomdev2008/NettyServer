package wang.gnim.netty.net.netty.pureSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import wang.gnim.netty.net.netty.pureSocket.SocketSession;

public enum SocketSessionCache {

	INSTANCE;
	
	private final Map<String, SocketSession> sessions = new ConcurrentHashMap<>();
	
	public void put(String roleId, SocketSession session) {
		sessions.put(roleId, session);
	}
	
	public SocketSession get(String ipPort) {
		return sessions.get(ipPort);
	}
	
	public boolean contains(String ipPort) {
		return sessions.containsKey(ipPort);
	}

}
