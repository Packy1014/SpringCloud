POST http://localhost:8781/api/v1/orders?userId=1&productId=1
启动eureka-server，product-service和order-service

1.该服务是由客户端决定调用哪个服务，所以是客户端负载均衡
2.新服务注册到Eureka后，要等一段时间才能被Ribbon发现。所以新注册的product-service，要等一段时间才能被order-service访问到
3.安装redis，启动命令./redis-server ../redis.conf
4.feign的timeout和hystrix的timeout时间取最短
5.查看默认讲解策略 HystrixCommandProperties
    1）execution.isolation.strategy   隔离策略
        THREAD 线程池隔离 （默认）
        SEMAPHORE 信号量
            信号量适用于接口并发量高的情况，如每秒数千次调用的情况，导致的线程开销过高，通常只适用于非网络调用，执行速度快
    2）execution.isolation.thread.timeoutInMilliseconds  超时时间
        默认 1000毫秒
    3）execution.timeout.enabled 是否开启超时限制 （一定不要禁用）
    4）execution.isolation.semaphore.maxConcurrentRequests 隔离策略为 信号量的时候，如果达到最大并发数时，后续请求会被拒绝，默认是10
6.hystrix dashboard访问入口
    http://localhost:8781/hystrix
    Hystrix Dashboard输入： http://localhost:8781/actuator/hystrix.stream 