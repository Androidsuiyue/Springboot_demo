package cn.qzhenghao.quartz;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/12/22.
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(SendMailQuartz.class);
    @Scheduled(cron = "*/5 * *  * * *")
    public void reportCurrentByCron(){
//        logger.info("定时器运行了！！！--------------");

    }
}
