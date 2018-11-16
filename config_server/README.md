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