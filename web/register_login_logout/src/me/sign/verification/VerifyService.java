package me.sign.verification;

import me.sign.people.Person;

import org.apache.commons.mail.EmailException;

public class VerifyService {
	public static boolean service(String mail) {
		//邮箱未被注册
		if (Visitor.isNew(mail)) {
			Person person = new Person();
			//生成随机验证码
			String code = Generator.code();
			//记录验证码生成时间
			long limit = System.currentTimeMillis();
			person.setUid(mail);
			person.setCode(code);
			person.setInTime(limit);
			//暂存邮箱验证的相关信息
			Visitor.insert(person);
			//向注册邮箱发送验证码
			try {
				Sender.mail(code, mail);
			} catch (EmailException e) {
				e.printStackTrace();
			}

			return true;
		}

		return false;
	}
}
