package cn.idragonboat.service.impl;

import java.io.File;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cn.idragonboat.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService{
	
	private static Logger logger = Logger.getLogger(SendMailServiceImpl.class);

	@Autowired
    private JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean
	
	
	@Override
	public Object sendMail() {
		logger.info("=======================开始发送邮件=======================");
		MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        String from;
        try {
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/conf/mail.properties"));
            from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo("844264382@qq.com");//收件人邮箱
            mMessageHelper.setSubject("Spring的邮件发送");//邮件的主题

            mMessageHelper.setText("你好，该睡觉了");
            File file=new File("C:/Users/84426/Pictures/Saved Pictures/code.png");//在邮件中添加一张图片
            FileSystemResource resource=new FileSystemResource(file);
            mMessageHelper.addInline("code", resource);//这里指定一个id,在上面引用
            mMessageHelper.addAttachment("代码.png", resource);//在邮件中添加一个附件
            javaMailSender.send(mMessage);//发送邮件
        } catch (Exception e) {
        	logger.info(e);
		}
        return "发送成功";
		
	}

}
