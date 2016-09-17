###注册-登录-注销模块

- sign
	- verification
		- Generator #生成随机验证码
		- Sender #发送随机验证码到注册邮箱
		- Visitor #邮箱验证阶段的数据库操作
	- register
		- User #注册完成阶段的数据库操作
	- login
		- User #登录验证阶段的数据库操作

- WebContent
	- register.html（注册/界面）
	- register-verify.js（注册/邮箱验证）
	- register-register.js（注册/完成）
	- login.jsp（登录/界面）
	- login-verify.js（登录/登录验证）
	- index.jsp（主界面）