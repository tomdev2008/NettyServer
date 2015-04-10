package wang.gnim.netty.server.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 容器管理
 * 
 * @author wangming
 *
 */
public enum SpringContext {

	INSTANCE;
    
    private final ApplicationContext context;

    private SpringContext() {
    	context = new ClassPathXmlApplicationContext(new String[]{"resource/springContext.xml"});
    }
    
    public ApplicationContext getApplicationContext() {
        return context;
    }
    
}
