实验课程任务2：软件体系结构设计

课程   体系结构与设计模式   实验名称      实验课程任务2：软件体系结构设计
          第      页
专业 软件工程  班级_软工      学号__121052022075__   姓名   林鸣晨   
实验日期：2024年04月 11日   报告退发 (订正 、 重做)                            
课程名称：软件体系结构设计 
作业类型：个人/小组作业（建议至多2人一组） 
截止时间：4月18日 周五。 
提交形式：PDF文档（含图表+文字说明）
一、作业背景 
请组成（2人）团队需设计一个在线教育系统，支持以下核心功能： 
1. 学生端：选课、观看视频、提交作业、实时答疑 
2. 教师端：上传课程、批改作业、在线答疑 
3. 支付系统：课程购买、订单管理 
4. 实时通信：学生与教师间的即时聊天 
具体需求描述，请查看后面的需求附录。 
二、作业任务提交内容要求

1. 逻辑视图









2. 开发视图 
目标：设计模块化架构和代码组织结构，同时给出代码的仓库地址（gitee/github）。 
https://github.com/daxiangfang/rjtxsj
2.1组件图（Component Diagram）：


2.2源码目录结构：
2.2.1course-service/
├── src/main/java/
│   ├── com/
│   │   └── example/
│   │       └── learningplatform/
│   │           ├── controller/       # API接口
│   │           │   └── CourseController.java
│   │           ├── service/          # 业务逻辑
│   │           │   └── CourseService.java
│   │           ├── model/            # 数据实体
│   │           │   └── Course.java
│   │           └── repository/       # 数据访问
│   │               └── CourseRepository.java
├── pom.xml                            # 依赖项
└── application.properties             # 配置文件
2.2.2user-service
user-service/
├── src/main/java/
│   ├── com/
│   │   └── example/
│   │       └── learningplatform/
│   │           ├── controller/       # API接口
│   │           │   └── UserController.java
│   │           ├── service/          # 业务逻辑
│   │           │   └── UserService.java
│   │           ├── model/            # 数据实体
│   │           │   └── User.java
│   │           └── repository/       # 数据访问
│   │               └── UserRepository.java
├── pom.xml                            # 依赖项
└── application.properties             # 配置文件
2.2.3.order-service
Order-service/
├── src/main/java/
│   ├── com/
│   │   └── example/
│   │       └── learningplatform/
│   │           ├── controller/       # API接口
│   │           │   └── OrderController.java
│   │           ├── service/          # 业务逻辑
│   │           │   └── OrderService.java
│   │           ├── model/            # 数据实体
│   │           │   └── order.java
│   │           └── repository/       # 数据访问
│   │               └── OrderRepository.java
├── pom.xml                            # 依赖项
└── application.properties             # 配置文件 
3. 进程视图 
目标：根据用例场景视图中的场景，来描述用例场景的实现流程。
3.1. 学生购买并学习课程


3.2. 教师创建并发布课程
异常分支： 
若视频格式不支持（如AVI），系统提示“仅支持MP4/WebM格式”。 
若未填写课程标题，系统阻止发布并提示“必填字段缺失”。



3.3. 学生提交作业与教师批改 
场景名称：作业提交与反馈流程 
1. 学生C 在课程《数据结构》的作业页面，点击“提交作业”。 
2. 上传作业文件：“二叉树遍历代码.zip”，并填写文字说明：“已实现递归与非递归解法”。 
3. 系统检查文件大小（≤50MB）和格式（ZIP/PDF），提交成功并显示“待批改”状态。 
4. 教师D 在“批改作业”页面： 
下载学生C的代码，运行测试用例（通过率90%）。 
评分：88/100，并添加评语：“非递归解法效率可优化”。 
5. 学生C收到通知：“您的作业《二叉树遍历》已批改”，查看反馈后修改代码重新提交。 
异常分支： 若作业逾期提交，系统标记为“迟交”，教师D可选择是否扣分。 
若学生C试图抄袭作业（系统检测相似度>70%），自动触发警告并通知教师。



3.4. 支付失败与订单恢复 
场景名称：支付超时后的订单处理 
1. 学生D 选择课程《深度学习》，点击“立即购买”生成订单（订单号：OD20241001）。 
2. 跳转至支付宝支付页面，但因网络中断支付未完成。 
3. 30分钟后，系统检测到订单状态仍为“待支付”，自动取消订单并释放课程名额。 
4. 学生D重新尝试支付时，系统提示：“订单已过期，请重新下单”。 
5. 学生D重新生成订单并成功支付，课程权限立即开通。 
异常分支： 
若支付中途银行卡余额不足，系统提示“支付失败，请更换支付方式”。 
若订单因系统错误重复扣款，触发自动退款流程（原路返回）。



4. 物理视图 
4.1目标：设计系统部署架构。 
要求： 
使用 部署图（Deployment Diagram），标注： 
服务器角色（Web服务器、应用服务器、数据库）。 
中间件（如Nginx、Kafka、Redis）。

·Web Server Layer：包括了 Web Server 和 Nginx，Nginx作为负载均衡器，管理 HTTP 请求的转发。
· Application Server Layer：处理业务逻辑的 Application Server，它连接到多个微服务（如 Payment Service、Course Service、User Service）。
·Database Layer：存储核心数据的 MySQL 数据库和 Redis 缓存层。
4.2并回答附加问题： 
为什么选择Kafka而非RabbitMQ作为消息队列？ 
答：选择 Kafka 而非 RabbitMQ 主要有以下几个原因：
高吞吐量：
Kafka 在设计上考虑了高吞吐量，能够处理大量的消息流。它可以高效地处理成千上万的消息，对于大规模分布式系统来说，Kafka 能更好地满足高并发要求。
RabbitMQ 更侧重于任务队列的消息传递，不适合处理极高并发的场景。
分布式特性：
Kafka 设计为分布式系统，它可以轻松水平扩展，支持集群部署。而 RabbitMQ 在集群模式下的扩展性较差，尤其是在处理消息量大的情况下。
Kafka 的分区机制使其能有效地分担负载，提高整体系统的可扩展性。
持久化和容错性：
Kafka 提供强大的消息持久化和容错机制，能够保证消息不会丢失，并且在节点故障的情况下，系统仍然能保持稳定。
RabbitMQ 也有持久化功能，但其持久化机制相对较弱，且在高并发环境下容易遇到性能瓶颈。
消息顺序性：
Kafka 可以保证同一主题的消息有严格的顺序，适用于需要保证顺序的场景。而 RabbitMQ 不保证消息的顺序性。
因此，选择 Kafka 作为消息队列在大规模、高并发、需要高可用和持久化的系统中表现更好。
如何设计数据库的读写分离？
答：数据库的读写分离是提高系统性能和可扩展性的一种常见设计方式。以下是常见的读写分离设计步骤：
主从数据库架构：
使用一个 主数据库 负责处理写请求，所有的数据修改（插入、更新、删除）都由主数据库执行。
使用多个 从数据库 负责处理读请求，所有的查询请求都可以由从数据库来处理。
负载均衡：
在数据库层部署负载均衡器，将读取请求分配到多个从数据库，以平衡各个从数据库的负载，提高读取性能。
可以使用 DNS 轮询或专门的负载均衡中间件来管理数据库的读请求分配。
数据同步：
主数据库和从数据库之间通过异步复制机制进行数据同步。主数据库的写入操作会被异步复制到从数据库，从而确保读取操作能够获取到最新的数据（注意，存在数据延迟的问题）。
选择合适的同步策略（如定时同步、日志同步等），确保数据一致性。
数据库路由：
应用层需要区分读请求和写请求，通常通过 AOP 或中间件在应用层进行数据库路由。写请求路由到主数据库，读请求路由到从数据库。
例如，使用 Spring 或 MyBatis 等框架，可以通过配置数据源路由实现自动读写分离。
缓存机制：
对于读取频繁但更新不频繁的数据，可以在缓存层（如 Redis）实现缓存策略，减少数据库的访问压力，进一步提升读取性能。
通过以上设计，可以大幅提高系统的性能，尤其是当系统的读取请求远多于写入请求时，数据库的读写分离可以有效分担负载，提高响应速度。
5.场景视图

