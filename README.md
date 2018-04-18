# springboot2-jarslink-example

[jarslink官网链接](https://github.com/alibaba/jarslink)

```
git clone https://github.com/devpage/springboot2-jarslink-example.git
cd springboot2-jarslink-example
mvn clean install
```

#删除[jarslink](https://github.com/alibaba/jarslink) 1行代码
```
com.alipay.jarslink.api.impl.SpringModule#clear
	LogFactory.release(classLoader);  // 删除这1行
```

启动：
mainClass jarslink.example.PlayJarsLink

default:
1. http://localhost:8080/action/set/a/123
2. http://localhost:8080/action/get/a

load mysql:
1. http://localhost:8080/action/reload/jarslink-example-mysql/0.0.1
2. http://localhost:8080/action/set/a/123
3. http://localhost:8080/action/get/a

load redis:
1. http://localhost:8080/action/reload/jarslink-example-redis/0.0.1
2. http://localhost:8080/action/set/a/123
3. http://localhost:8080/action/get/a