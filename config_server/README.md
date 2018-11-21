1.配置文件访问路径
http://localhost:9100/product-service-test.yml
http://localhost:9100/product-service-dev.yml

2.配置文件访问方式（一定要注意语法，如果有问题，会出错）
/{name}-{profiles}.properties
/{name}-{profiles}.yml
/{name}-{profiles}.json
/{label}/{name}-{profiles}.yml
name 服务器名称
profile 环境名称，开发、测试、生产
lable 仓库分支、默认master分支

3.从配置服务器拉取配置的项目必须加bootstrap.yml，application.yml加载顺序在bootstrap.yml之后

4.docker安装rabbitmq
yum update
yum clean all
#yum install epel-release -y
yum install docker
systemctl start docker
docker info
docker pull rabbitmq:management
docker run -d --name packy_rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management

5.配置总线动态刷新服务配置，并且对所有部署该服务的节点均有效
http://localhost:8771/api/v1/products/1，env为test
开启actuator
在需要刷新配置的类上加入@RefreshScope
POST发送localhost:8771/actuator/bus-refresh，手动刷新配置