package com.zl.spbm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.zl.spbm.service.inter.IMailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	@Autowired
    private IMailService mailService;
	
	@Autowired
	TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
    	mailService.sendSimpleMail("852782009@qq.com","test simple mail"," hello this is simple mail");
    }
    
    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("852782009@qq.com","test simple mail",content);
    }
    
    @Test
    public void sendAttachmentsMail() {
        String filePath="C:\\Users\\qk203\\Pictures\\diagram0.jpeg";
        mailService.sendAttachmentsMail("852782009@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
    
    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("852782009@qq.com","主题：这是模板邮件",emailContent);
    }
    
}
