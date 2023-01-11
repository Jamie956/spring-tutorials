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

or (2)
vm options: -Dfile.encoding=UTF-8

# env
tomcat 8.5.84
javax.servlet-api scope is provided, servlet-api.jar already provide by tomcat lib

tomcat 10 return 404 error, servlet-api.jar no longer provide by tomcat lib

# importance class
replace web.xml, request dispatcher
AbstractAnnotationConfigDispatcherServletInitializer

springMVC bean config, replace springMVC.xml
WebMvcConfigurer


DispatcherServlet: 统一处理请求和响应
HandlerMapping: 根据请求url, method等信息查找Handler
Handler: 开发者实现，处理用户具体请求
HandlerAdapter: 
ViewResolver: 视图解析，ThymeleafView, InternalResourceView, RedirectView
View: 将模型数据通过页面展示给用户