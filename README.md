# springboot2-jarslink-example

```
git clone https://github.com/devpage/springboot2-jarslink-example.git
cd springboot2-jarslink-example
mvn clean install
```

** important

#删除1行代码
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