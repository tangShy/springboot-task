package com.akon.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("开会通知");
        message.setText("今天下午3点，全体人员大会议室开会！");
//        message.setTo("1394397636@qq.com");
        message.setTo("akon_1234567@163.com");
        message.setFrom("975751290@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test() throws Exception {
        // 创建一个复杂的邮件
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);

        // 邮件设置
        helper.setSubject("通知-周一早上早点到");
        helper.setText("所有同学周一早上九点之前到！");

        helper.setTo("akon_1234567@163.com");
        helper.setFrom("975751290@qq.com");

        // 上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\13943\\Pictures\\壁纸\\t01e8fb12b23934349f.webp.jpg"));

        mailSender.send(mailMessage);

    }

}
