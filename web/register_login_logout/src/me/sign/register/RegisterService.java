package me.sign.register;

import java.util.HashMap;
import java.util.List;

public class RegisterService {
	public static boolean service(String uid, String code, String key) {
		List<String> list = User.retrieve(uid);
		//验证验证码时间是否有效
		if (Long.parseLong(list.get(0)) - System.currentTimeMillis() > 10 * 60 * 1000)
			return false;
		//验证验证码是否正确
		else if (!list.get(1).equals(code))
			return false;
		//验证成功，将邮箱、密码存入数据库
		else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("uid", uid);
			map.put("key", key);

			User.register(uid, map);
			return true;
		}
	}
}
