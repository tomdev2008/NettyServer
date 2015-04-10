package wang.gnim.netty.server.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public enum PropertiesConfig {

	ROUTER_TYPE() {
		public String value() {
			return LoadConfig.properties.getProperty("router_type");
		}
	};

	public abstract String value();

	protected static class LoadConfig {
		
		protected static final Properties properties = new Properties();
		
		{
			try {
				properties.load(new InputStreamReader(getClass().getResourceAsStream(
						"resource/server.properties"), "UTF-8"));

			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}
