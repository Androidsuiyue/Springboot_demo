package cn.qzhenghao.quartz;

import cn.qzhenghao.model.User;
import cn.qzhenghao.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */
@Service
class SendJunklMailServiceImp implements SendJunkMailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Resource
    private AyUserService ayUserService;

    @Value("${spring.mail.username}")
    private String name;

    Logger logger = LogManager.getLogger(SendJunklMailServiceImp.class);


    @Override
    public boolean sendJunkMail(List<User> users)  {
//
//        if (users != null && users.size() >= 0) {
//            for (User u :
//                    users) {
//                MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
//                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
//                try {
//                    mimeMessageHelper.setFrom(name);
//                    mimeMessageHelper.setSubject("jjjjjjjjj");
//                    mimeMessageHelper.setText(u.getName() + "我发的 的邮件");
//                    mimeMessageHelper.setTo(name);
//                    this.javaMailSender.send(mimeMessage);
//
//                } catch (MessagingException e) {
//                    logger.error("Send mail error jjjj !!! and User=%s", users, e);
//                    return false;
//
//                }
//            }
//            return true;
//        }
        return false;
    }

}
