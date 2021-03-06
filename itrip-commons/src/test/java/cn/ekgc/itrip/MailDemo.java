package cn.ekgc.itrip;

import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailDemo {
	public static void main(String[] args) {
		//用于发送邮件
		JavaMailSender mailSender = new JavaMailSenderImpl();
		//创建邮件信息对象
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		//收件人
		mailMessage.setTo("");
		//发件人
		mailMessage.setFrom("");
		//邮件主题
		mailMessage.setSubject("");
		//邮件内容
		mailMessage.setText("");

		//设置邮箱信息
		mailSender.send(mailMessage);
	}
}
