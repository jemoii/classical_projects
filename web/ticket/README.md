###12306余票查询

#####[示例页面](http://jemoii.duapp.com/ticket)

#####查询过程
1.	获取查询参数“出发站点”和“到达站点”；
2.	查询数据库，获取站点对应的英文编码；
3.	通过API获取JSON格式的余票信息；
4.	处理获取的余票信息，显示。

#####查询结构

	- station
		- request
			- DateUtil #在0.1.6版本中用于日期处理
			- MySQLUtil #用于获取站点对应的英文编码
		- response
			- Browser #使用API
			- XMLUtil #用于处理JSON格式的余票信息
		- servlet
			- model
				- CoreService
			- web
				- CoreServlet #用于页面交互
		- ssl
			- MyX509TrustManager #用于处理HTTPS的相关问题
		- train
			- Train #用于包含关于车次的信息

#####更新日志

1.1.20

1. 修改日期的获取方式
2. 修改余票信息的显示

0.1.6

1. 实现基本的查询功能

#####主页

<http://jemoii.github.io/>