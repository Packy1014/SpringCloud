POST http://localhost:8781/api/v1/orders?userId=1&productId=1
启动eureka-server，product-service和order-service

1.该服务是由客户端决定调用哪个服务，所以是客户端负载均衡
2.新服务注册到Eureka后，要等一段时间才能被Ribbon发现。所以新注册的product-service，要等一段时间才能被order-service访问到