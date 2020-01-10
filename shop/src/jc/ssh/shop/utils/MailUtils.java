package jc.ssh.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



public class MailUtils {
	public static void sendMail(String to, String code) throws Exception{
	Properties props = new Properties();
	props.setProperty("mail.smtp","localhost");
	
	Session session = Session.getInstance(props, new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("service@shop.com", "123");		
		}
	});
	
	//构建邮件信息
	Message message = new MimeMessage(session);
	
	// 发件人:
			message.setFrom(new InternetAddress("service@shop.com"));
			// 收件人:
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置标题
			message.setSubject("来自SHOP激活邮件");
			// 设置正文
			message.setContent("<h1>来自SHOP的官网激活邮件</h1><h3><a href='http://localhost/shop/user_active.action?code="+code+"'>http://192.168.40.99:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		
			// 3.发送对象
			Transport.send(message);
	
	}		

}
