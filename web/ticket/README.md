####12306余票查询

####[DEMO](http://jemoii.duapp.com/ticket)

#####查询过程
1.	获取查询参数“出发站点”和“到达站点”；
2.	查询数据库，获取站点对应的英文编码；
3.	通过API获取JSON格式的余票信息；
4.	处理获取的余票信息，显示。

####查询结构
- me
	- station
		- request
		- response
		- servlet
			- model
			- web
		- ssl
		- train
