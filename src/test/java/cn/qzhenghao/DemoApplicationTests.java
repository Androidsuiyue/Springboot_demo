package cn.qzhenghao;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.qzhenghao.config.WxMaConfiguration;
import cn.qzhenghao.listener.AyuserListener;
import cn.qzhenghao.model.AyMood;
import cn.qzhenghao.model.AyUserAttachmentRel;
import cn.qzhenghao.model.User;
import cn.qzhenghao.quartz.AyMoodProducer;
import cn.qzhenghao.repository.AyUserRepository;
import cn.qzhenghao.service.AyMoodService;
import cn.qzhenghao.service.AyUserAttachmentRelService;
import cn.qzhenghao.service.AyuserServiceimp;
import cn.qzhenghao.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemoApplicationTests {
//有这个的话好像都要加
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
    private AyuserServiceimp ayuserServiceimp;


    @Test
	public void contextLoads() {
		String sql ="select id,name,password from ay_user";
        List<User> query = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getNString("password"));
                return user;
            }
        });

        System.out.println("------查询成功");
        System.out.println("------查询成1111功");
        for (User u :
                query) {
            System.out.println(u.toString());

        }
    }
    @Test
    public void test() {




    }

    @Resource
    AyUserRepository ayUserReposiory;
    @Test
    public void testRepository(){
        //查询所以数据


        //通过name查询数据


        //通过name模糊查询

        //通过id集合查询

        //分页查询数据

        //可以
        PageRequest pageRequest = new PageRequest(0,10);
        Page<User> all = ayUserReposiory.findAll(pageRequest);
        int totalPages = all.getTotalPages();
        int number = all.getNumber();
        List<User> content = all.getContent();
        int size = all.getSize();
        String s = content.toString();
        System.out.println(totalPages+" |"+number+"|"+"|"+s);


        //新增数据

        //删除数据

    }

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        List<User> all = ayuserServiceimp.findAll();
        redisTemplate.opsForList().leftPushAll(AyuserListener.ALL_USER, all);
        logger.info("777777777777777777----------------------------");


//        List<User> range = redisTemplate.opsForList().range(AyuserListener.ALL_USER, 0, -1);
        List range1 = redisTemplate.opsForList().range(AyuserListener.ALL_USER, 0, -1);
        logger.info(range1.get(1).toString()+"-----------888888---------");
//        if (range != null && range.size() > 0) {
//            for (User u :
//                    range) {
//                logger.info(u.toString());
//            }
//        }

//
//        System.out.println(new String(data));
//        data =str.getBytes("utf-8"); //设定编码字符集
//        //不同一出现乱码
//        System.out.println(new String(data));
//
//        //编码
//        byte[] data2 = "中国".getBytes("utf-8");
//        //解码
//        str=new String(data2,"utf-8");
//        System.out.println(str);
    }

    Logger logger = LogManager.getLogger(this.getClass());
    @Test
    public void testLogger(){

        List<User> all = ayuserServiceimp.findAll();
        List<User> all1 = ayUserReposiory.findAll();
        logger.info(all1.toString());
        logger.info(all.toString());
        ayuserServiceimp.delete("1");
        List<User> all2 = ayuserServiceimp.findAll();
        logger.info(all2);


        //        User byId = ayuserServiceimp.findById()
//        logger.info(byId.toString());
//        User byId1 = ayUserReposiory.findById("1");
//        logger.info(byId.toString());
//        ayuserServiceimp.delete("1");
//        logger.info("jjfjejfjeifiejfei");

    }

    @Test
    public void mybatisTest() {
        User user = new User();
        user.setId("4");
        user.setName("出去");
        user.setPassword("11");

        User save = ayuserServiceimp.save(user);
        logger.info(save.toString()+"kkkkkkkkkkkkkkkkkkk");
        User qianh = ayuserServiceimp.findByNameAndPassword("出去", "11");
        logger.info(qianh+"kkkkkkkkkkkkkkkkkkk");

    }
    @Resource
    public AyMoodService ayMoodService;
    @Test
    public void activeMQTest(){
        AyMood ayMood = new AyMood();
        ayMood.setId("2");
        ayMood.setContent("这是我的第一条说说111");
        ayMood.setPraiseNum(0);
        ayMood.setUserId("2");
        ayMood.setPublishTime(new Date());
        AyMood save = ayMoodService.save(ayMood);



        List<AyMood> all = ayMoodService.findAll();
        logger.info(all.toString() + "lllllllllllllllllllllllllll");


    }

    @Resource
    public AyMoodProducer ayMoodProducer;
    @Test
    public void setAyMoodProducerTest(){

        ActiveMQQueue activeMQQueue = new ActiveMQQueue("ay.queue");
        ayMoodProducer.sendMessage(activeMQQueue, "hello,mq!!");

    }

    @Test
    public void activeMQAsynTest(){
        AyMood ayMood = new AyMood();
        ayMood.setId("2");
        ayMood.setUserId("2");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第一条微信说说！");
        ayMood.setPublishTime(new Date());
        AyMood save = ayMoodService.save(ayMood);
        String s = ayMoodService.asynSave(ayMood);
        System.out.println("异步发表说说" + s);

    }

    @Resource
    public AyUserAttachmentRelService ayUserAttachmentRelService;
    @Test
    public void mongodbTest(){
        AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
        ayUserAttachmentRel.setFileNmae("个人简历.doc");
        ayUserAttachmentRel.setId("1");
        ayUserAttachmentRel.setUserId("1");
        ayUserAttachmentRelService.save(ayUserAttachmentRel);
        System.out.println("保存成功！！！！+jjjjj");

    }
    @Test
    public void loginTest() {
        String appid = "wxbf4a143fe7c49e5e";
        String code = "abeaf45e51afdee1712c574af037a06d";

            System.out.println(new Date(0) + "empty jscode！！！      ！+jjjjj");


    }

}
