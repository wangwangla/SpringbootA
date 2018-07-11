# SpringbootA
多项目练习，springboot使用maven练习，这个是最简单的方法，可以作为项目摸版下载


笔记一：
在使用多模块的时候，需要使用set注入，但是还是需要加上自动注入的注解（原因不清楚）
数据传入的时候需要使用注解，才可以得到json的数据，我记得之前一个模块的时候这个好像也不是必须的，可以写，也可以不写。

多模块通过pom来体现依赖关系。

接口测试地址http://localhost:8080/save

git使用说明
如果当前分支与多个主机存在追踪关系，则可以使用-u选项指定一个默认主机，这样后面就可以不加任何参数使用git push。

-u指定主机 

一般使用步骤：
（1）git add ./ 
（2）commit -m "说明"
（3）git push -u origin master (可以选择其他的分支等)



笔记二：
	权限控制，使用AOP进行切面验证，在访问之前对cookie进行效验


	踩得坑：不知道aop使用拦截后，路径去了哪里，
	默认的路径是根路径，如果需要在验证失败去跟路径/，就需要将范湖登录页面，将默认路径修改即可,不过他的做法是转发，不是重定向。

	可以在异常的处理方法中加入返回路径，如果没写则是默认路径，也可以通过自己指定。

笔记三：
	将数据 的返回值进行封装，完善返回值格式，将业务层和资源层的数据封装分开，使用bean的方式	完成


	未解决的问题：redis保存hashset报错，实体不可以转换为string，具体原因不知道

	计划:做一个商家和卖家的功能 spring boot+vue
