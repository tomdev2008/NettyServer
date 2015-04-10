package wang.gnim.netty.server.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonTool {

	private static final Gson gson = new GsonBuilder()
										.setPrettyPrinting()
										.setExclusionStrategies(new MyExclusionStrategy())
										.create();
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	private static class MyExclusionStrategy implements ExclusionStrategy {


		MyExclusionStrategy() {
		}

		@Override
		public boolean shouldSkipClass(Class<?> clazz) {
			return false;
		}

		@Override
		public boolean shouldSkipField(FieldAttributes f) {
			return f.getName().equals("bitField0_") ||
					f.getName().equals("memoizedIsInitialized") ||
					f.getName().equals("memoizedSerializedSize");
		}
	}
}
