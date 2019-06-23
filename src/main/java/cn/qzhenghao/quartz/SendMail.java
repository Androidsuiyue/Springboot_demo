package cn.qzhenghao.quartz;

import cn.qzhenghao.model.User;
import cn.qzhenghao.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/12/25.
 */
@Component
@Configurable
@EnableScheduling
public class SendMail {

    org.apache.logging.log4j.Logger logger = LogManager.getLogger(SendMail.class);
    @Resource
    private SendJunkMailService sendJunkMailService;

    @Resource
    private AyUserService ayUserService;


    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentByCron(){
//        List<User> all = ayUserService.findAll();
//        String s = all.toString();
//        logger.info(s+"jjjjj");
//
//
//        if (all != null && all.size() > 0) {
//            try {
//                sendJunkMailService.sendJunkMail(all);
//            } catch (MessagingException e) {
//                logger.error("scheduling mail error !!!kkjjjj", e);
//            }
//            logger.info("定时器运行了！！！！！jjj");
//
//        }
//
  }

}
