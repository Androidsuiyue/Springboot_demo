package cn.qzhenghao.service;


import cn.qzhenghao.dao.AyUserMapper;
import cn.qzhenghao.error.BussinessException;
import cn.qzhenghao.model.User;
import cn.qzhenghao.repository.AyUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/12/12.
 */
@Service
public class AyuserServiceimp implements AyUserService,Serializable {

@Resource
private AyUserRepository ayUserReposiory;


    @Resource
    private RedisTemplate redisTemplate;
    Logger logger=LogManager.getLogger(this.getClass());

    /**
     * 引入redis可以提高性能，但代码复杂度也提高了
     * redis数据放到缓存中 是有时效性的 所以要配合数据库
     * 这里对查找id方法进行更新 使其先在redis中 找不到再去数据库中，并更新redis
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        //step1 查询redis缓存中的数据
//        List<User> range = redisTemplate.opsForList().range(AyuserListener.ALL_USER, 0, -1);
//        if (range != null && range.size() > 0) {
//            for (User u :
//                    range) {
//                return u;
//            }
//        }




        return ayUserReposiory.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return ayUserReposiory.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

//        User save = ayUserReposiory.save(user);
//        //此时会报空指针，数据会回滚，
//        String error =null;
//        error.split("/");
        return this.ayUserReposiory.save(user);
    }

    @Override
    public void delete(String id) {
        ayUserReposiory.delete(id);
        //用logger输出
        logger.info("userId"+id+"用户被删除");

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return ayUserReposiory.findAll(pageable);
    }

    @Override
    public List<User> findByName(String name) {
        return ayUserReposiory.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return ayUserReposiory.findByNameLike(name);
    }

    @Override
    public List<User> findByIdIn(Collection<String> ids) {
        return ayUserReposiory.findByIdIn(ids);
    }

    @Resource
    public AyUserMapper ayUserDao;

    @Override
    public User findByNameAndPassword(String name, String password) {

        User byNameAndPassword = ayUserDao.findByNameAndPassword(name, password);
        return byNameAndPassword;
    }

    //value属性表示出现哪些异常是触发重试，maxAttempts表示最大重试次数默认3，delay表示重试的延迟时间 ，multiplie表示上一次延时时间是这一次的倍数
    @Override
    @Retryable(value = {BussinessException.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public User findByNameAndPasswordRetry(String name, String password) {
        System.out.println("[findByNameAndPasswordRetry]方法失败重试了");

        throw new BussinessException();
    }


}
