如果想要调用logback.xml文件, 则代码里必须调用slf4j-api-1.7.5.jar里的代码, 如org.slf4j.Logger;
log4j-1.2.17.jar(如org.apache.log4j.Logger) 只会去寻找log4g.properties文件

	<appender name="SocketAppenderN" class="ch.qos.logback.classic.net.SocketAppender">
		<remoteHost>${host}</remoteHost>
		<port>${port}</port>
		<reconnectionDelay>10000</reconnectionDelay>
		<encoder> 
      		<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>   
    	</encoder> 
	</appender>
	
	<receiver class="ch.qos.logback.classic.net.server.ServerSocketReceiver">
    	<port>${port}</port>
  	</receiver>
	

	
将日志输出到console, 根据target 有俩个选项,可选择输出到System.out或者System.err. 
	
	<appender name="ConsoleAppenderN" class="ch.qos.logback.core.ConsoleAppender">
		<target>System.out</target>
		<encoder>   
      		<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>   
    	</encoder> 
	</appender>
	
输出 log到文件, 如果append为true的话, 则会在文件里接着写, 为false的话, 会将文件里已有的内容删除掉

	<appender name="FileAppenderN" class="ch.qos.logback.core.FileAppender">
		<append>true</append>
		<file>log-${bySecond}.txt</file>
		<prudent></prudent>
		<encoder>   
      		<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>   
    	</encoder> 
	</appender>
	
	
OutputStreamAppenderN 一般用户不会直接使用这个Appender

	<appender name="OutputStreamAppenderN" class="ch.qos.logback.core.OutputStreamAppender">
	</appender>