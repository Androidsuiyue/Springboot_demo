package cn.qzhenghao.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Created by Administrator on 2018/12/21.
 */
public class TestTask {
    Logger logger = LogManager.getLogger(TestTask.class);



    public void run() {
        logger.info("定时器运行了----------------------------------");
    }
}
