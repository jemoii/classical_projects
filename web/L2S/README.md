###实现短链接

#####转换过程

#####转换结构

	- l2s
		- clazz
			- L2S #用于包含转换结果的信息
		- jackson
			- C2J #使用Jackson API
		- jedis
			- L2P #使用Jedis API
			- L2R #使用长链接生成随机字符串
            - P2T #使用Jedis API
		- web
        	- c
            	- CoreService
                - ViceService
            - v
            	- CoreServlet

#####主页

<http://jemoii.github.io/>