package cn.qzhenghao.service;

import cn.qzhenghao.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/12/12.
 */

public interface AyUserService {
    User findById(String id);
    List<User> findAll();
    User save(User user);
    void delete(String id);
    //分页
    Page<User> findAll(Pageable pageable);

    //通过名字查询
    List<User> findByName(String name);
    //通过名字立刻查询
    //select u from ay_user u where u.name like ？l1
    List<User> findByNameLike(String name);
    //通过主键集合 查询
    //select u from ay_user u where id in (?,?,?)
    List<User> findByIdIn(Collection<String> ids);

    User findByNameAndPassword(String name,String password);
    //重传
    User findByNameAndPasswordRetry(String name,String password);

}

