1.默认访问规则  
http://gateway:port/service-id/**
例子：http://localhost:9000/order-service/api/v1/orders?userId=1&productId=1
2.用zuul.routes把product-service自定义为/gateway/product
例子：http://localhost:9000/gateway/product/api/v1/products
3.用ignored-services把不想向外暴露的api屏蔽
4.cookie无法传递到具体服务是由于网关默认过滤掉了请求头里的cookie，Set-Cookie和Authorization，添加sensitive-headers属性
http://localhost:9000/gateway/order/api/v1/orders?userId=1&productId=1，在请求header加上token属性
5.登陆只拦截http://localhost:9000/gateway/product/api/v1/products请求，必须要在header里面加入token属性
6.针对http://localhost:9000/gateway/product/api/v1/products请求做限流