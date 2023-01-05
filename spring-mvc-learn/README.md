# spring mvc idea config
project structure -> modules -> add web 
-> web resource directory: D:\dev\project\spring-tutorials\spring-mvc-learn\demo1\src\main\webapp
-> development descriptor: D:\dev\project\spring-tutorials\spring-mvc-learn\demo1\src\main\webapp\WEB-INF\web.xml

# server logs 中文乱码
(1)
apache-tomcat-8.5.84\conf\logging.properties
java.util.logging.ConsoleHandler.encoding = UTF-8
->
java.util.logging.ConsoleHandler.encoding = GBK

(2)
vm options: -Dfile.encoding=UTF-8

# env
tomcat 8.5.84
javax.servlet-api scope is provided, servlet-api.jar already provide by tomcat lib

tomcat 10 return 404 error, servlet-api.jar no longer provide by tomcat lib