# homework 10

用docker方式部署redis，启动2个tomcat实例，实现分布式Session功能，验证方式如下：
用户第一次访问某个页面/distSession/
如果没有Session，则出现HTML表单，
用户输入年龄，姓名，点击确认，提交服务端，创建UserInfoBean，放入Session，转到/distSession/listMyInfo页面展示信息。
注意要校验年龄为18+到99之间，姓名只能是英文字符和数字，长度为6-18
当某个Tomcat杀死后，可以访问另外一个Tomcat，正常显示Session里的页面，证明Session分布式成功。

