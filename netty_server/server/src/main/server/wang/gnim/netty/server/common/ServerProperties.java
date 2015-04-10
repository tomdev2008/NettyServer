package wang.gnim.netty.server.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public enum ServerProperties {
	
	SERVER_ID("server_id"),
	MYSQL_URL("mysql_url");
	
	
	
	ServerProperties(String key) {
		value = PropertiesLoad.properties.getProperty(key);
	}
	public String value;
	
	
	public int intValue() {
		return Integer.parseInt(value);
	};
	/**
	 * 使用静态内部类确保资源智慧被加载一次
	 * @author wangming
	 *
	 */
	private static class PropertiesLoad {
		
		static final Properties properties = new Properties();
		static {
			try(InputStreamReader reader = new InputStreamReader(new FileInputStream(
					"src/server/resource/server.properties"), "UTF-8")) {
				
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
