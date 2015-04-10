package wang.gnim.netty.server.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.util.ClassFinder;

public class TestClassFinder {

	@Test
	public void test_findClass_action() {
		List<Class> classes = ClassFinder.findClasses("netty.framework.action", "Action");
		
		Assert.assertEquals(1, classes.size());
	}
	
	@Test
	public void test_findClass_message() {
		List<Class> classes = ClassFinder.findClasses("netty.framework.messages", "Message");
		
		Assert.assertEquals(2, classes.size());
	}
}
