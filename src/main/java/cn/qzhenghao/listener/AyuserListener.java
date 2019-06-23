package cn.qzhenghao.listener;

import cn.qzhenghao.repository.AyUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Created by Administrator on 2018/12/17.
 */
@WebListener
public class AyuserListener implements ServletContextListener {

    //引入Logger类
    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private AyUserRepository ayUserReposiory;
    public static final String ALL_USER = "ALL_USER_LIST";


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        List<User> all = ayUserReposiory.findAll();
//        logger.info(all.toString()+"-0---------0-09-9-0-----------------");
//        redisTemplate.delete(ALL_USER);

//        redisTemplate.opsForList().leftPushAll(ALL_USER, all);
//        List<User> range1 = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//        logger.info(range1.toString() + "-----------------------" );
//        System.out.println(range1 + "------------------" );
//        List range = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//
//        logger.info(range.toString());
//        System.out.println(range.size() + "缓存中有多少人");



        System.out.println("ServletContext ------------------ init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


        System.out.println("ServletContext_____________destory");
    }
}
