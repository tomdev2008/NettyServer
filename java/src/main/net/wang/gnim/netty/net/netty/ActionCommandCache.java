package wang.gnim.netty.net.netty;

import io.robertsing.nettyserver.messages.MsgId.MsgID;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;




import wang.gnim.netty.server.action.AbstractAction;
import wang.gnim.netty.server.command.AbstractCommand;
import wang.gnim.netty.server.util.ClassFinder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.protobuf.Parser;

/**
 * 保存action类和解析protobuf的parser类
 * @author wangming
 *
 */
public enum ActionCommandCache {

	INSTANCE;
	
	private final Logger logger = Logger.getLogger(ActionCommandCache.class);
	
	// parser解析器
	private final Map<String, Parser> requestMap = new HashMap<>();
	private final Map<String, Parser> responseMap = new HashMap<>();
	
	// actions
	private final Map<String, AbstractAction> actions = new HashMap<>();
	
	// commands
	private final Table<String, String, AbstractCommand> commands = HashBasedTable.create();
	
	// 服务器启动时,初始化parser 和actions
	public void init() {

		logger.debug("begain load actions and parsers");

		try {
			parseAction("netty.framework.action", "Action");
			parseCommand("netty.framework.command", "Command");
			
			parseMessage(requestMap, "Request");
			parseMessage(responseMap, "Response");

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private void parseCommand(String packag, String suff)
			throws InstantiationException, IllegalAccessException {
		List<Class> actionclass = ClassFinder.findClasses(packag, suff);
		for (Class action : actionclass) {
			String[] splits = action.getName().split("\\.");
			String actionName = splits[splits.length - 1];
			String name = actionName.split(suff)[0];

			if (name.equals("Abstract"))
				continue;

			String type = splits[splits.length - 2];
			commands.put("/" + type, name, (AbstractCommand) action.newInstance());

			logger.debug("Load " + suff + " : " + name);
		}
	}
	
	private void parseAction(String packag, String suff) throws InstantiationException,
			IllegalAccessException {
		List<Class> actionclass = ClassFinder.findClasses(packag, suff);
		for (Class action : actionclass) {
			String[] splits = action.getName().split("\\.");
			String actionName = splits[splits.length - 1];
			String name = actionName.split(suff)[0];

			if(name.equals("Abstract"))
				continue;
			
			actions.put(name.toUpperCase(), (AbstractAction) action.newInstance());
			
			logger.debug("Load " + suff + " : " + name);
		}
	}
	
	private void parseMessage(Map<String, Parser> map,  String classEndName) {
		
		List<Class> requests = ClassFinder.findClasses(
				"netty.framework.messages", classEndName);
		
		for (Class message : requests) {
			try {
				String[] splits = message.getName().split("\\.");
				String messageName = splits[splits.length - 1];
				messageName = messageName.split("\\$")[1].split(classEndName)[0];
				messageName = messageName.toUpperCase();
				logger.debug("load " + classEndName + " : " + messageName);
				
				Method defaultInstance = message.getMethod("getDefaultInstance");
				Object newBuilder = defaultInstance.invoke(message);

				Method getParserForType = newBuilder.getClass().getMethod("getParserForType");
				
				Parser parser = (Parser)getParserForType.invoke(newBuilder);
				map.put(messageName, parser);
				
			} catch (final Exception e1) {
				e1.printStackTrace();
				return;
			}
		}
	}
	
	public Parser getRequestParserBy(int id) {
		return requestMap.get(MsgID.valueOf(id).name());
	}
	
	public Parser getResponseParserBy(int id) {
		return responseMap.get(MsgID.valueOf(id).name());
	}
	
	public AbstractAction getAction(String key) {
		return actions.get(key);
	}
	
	public AbstractCommand getCommand(String type, String key) {
		return commands.get(type, key);
	}
}
