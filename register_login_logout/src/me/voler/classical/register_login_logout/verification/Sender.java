package me.voler.classical.register_login_logout.verification;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Sender {
    private final static String PASSWORD = "******";

    public static void mail(String code, String to) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("******", PASSWORD));
        email.setSSLOnConnect(true);
        email.setFrom("******");
        email.setSubject("***注册验证码");
        email.setMsg("欢迎注册***，请将验证码（" + code + "）填入验证栏。" + "\n"
                + "该验证码10分钟内有效，请尽快完成注册。");
        email.addTo(to);
        email.send();
    }
}
