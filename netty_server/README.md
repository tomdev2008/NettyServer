# 基于Netty和Protobuf构建的NIO服务器 #
## 实现的功能 ##
1. 实现了Http服务器
2. 实现了纯socket服务器
3. 添加了对mybatis的支持
4. 添加了对quartz的支持
5. 使用spring管理mybatis和quartz
6. 添加了log4j功能
7. 完成了业务单元测试框架(不基于网络通信)
8. 添加了ID生成策略,实现了基于内存自增长和基于Flicker TicketServer的ID生长策略
9. 

## 待完善的 ##
1. 测试使用NioEventLoopGroup业务线程池的网络承载量
2. 添加disruptor对并发支持
3. 添加akka actor对并发的支持
4. 添加kilim对并发的支持
5. 打包工具
6. 服务器启动脚本(jvm配置)
7. IdleStateHandler处理
8. 合理设置接收和发送缓冲区容量
9. CLOSE_WAIT,close_wait状态的链路并不释放句柄和内存等资源，如果积压过多可能会导致系统句柄耗尽,及时关闭socket
10. 合理的心跳周期
11. 是否需要在代码里添加对nginx支持
12. 添加cobar分库支持
13. IdleStateHandler会根据用户的使用场景，启动三类定时任务，分别是：ReaderIdleTimeoutTask、WriterIdleTimeoutTask和
    AllIdleTimeoutTask，它们都会被加入到NioEventLoop的Task队列中被调度和执行。由于超时时间过长，10W个长链接链路会创建
    10W个ScheduledFutureTask对象，每个对象还保存有业务的成员变量，非常消耗内存
14. Linux内核参数最大句柄数修改,使其能够支持更多的长连接
15. 客户端的重连间隔需要合理设置，防止连接过于频繁导致的连接失败（例如端口还没有被释放）；
16. 客户端重复登陆拒绝机制；
17. 服务端正确处理I/O异常和解码异常等，防止句柄泄露。
18. 由于网络不稳定经常会导致客户端断连，如果服务端没有能够及时关闭socket，就会导致处于close_wait状态的链路过多。
    close_wait状态的链路并不释放句柄和内存等资源，如果积压过多可能会导致系统句柄耗尽，发生“Too many open files”异常，
    新的客户端无法接入，涉及创建或者打开句柄的操作都将失败。
19. 
