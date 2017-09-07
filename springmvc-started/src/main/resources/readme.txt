运行步骤：
1、  首先用户发送请求http://localhost:9080/springmvc-started/hello——>web容器，web容器根据“/hello”路径映射到DispatcherServlet（url-pattern为/）进行处理；
2、  DispatcherServlet——>BeanNameUrlHandlerMapping进行请求到处理的映射，BeanNameUrlHandlerMapping将“/hello”路径直接映射到名字为“/hello”的Bean进行处理，即HelloWorldController，BeanNameUrlHandlerMapping将其包装为HandlerExecutionChain（只包括HelloWorldController处理器，没有拦截器）；
3、  DispatcherServlet——> SimpleControllerHandlerAdapter，SimpleControllerHandlerAdapter将HandlerExecutionChain中的处理器（HelloWorldController）适配为SimpleControllerHandlerAdapter；
4、  SimpleControllerHandlerAdapter——> HelloWorldController处理器功能处理方法的调用，SimpleControllerHandlerAdapter将会调用处理器的handleRequest方法进行功能处理，该处理方法返回一个ModelAndView给DispatcherServlet；
5、  hello（ModelAndView的逻辑视图名）——>InternalResourceViewResolver， InternalResourceViewResolver使用JstlView，具体视图页面在/WEB-INF/jsp/hello.jsp；
6、  JstlView（/WEB-INF/jsp/hello.jsp）——>渲染，将在处理器传入的模型数据(message=HelloWorld！)在视图中展示出来；
7、  返回控制权给DispatcherServlet，由DispatcherServlet返回响应给用户，到此一个流程结束。
