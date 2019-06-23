package cn.qzhenghao.repository;

import cn.qzhenghao.model.User;
import javafx.print.Collation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/12/12.
 */
public interface AyUserRepository extends JpaRepository<User,String> {
    //通过名字查询
    List<User> findByName(String name);
    //通过名字立刻查询
    //select u from ay_user u where u.name like ？l1
    List<User> findByNameLike(String name);
    //通过主键集合 查询
    //select u from ay_user u where id in (?,?,?)
    List<User> findByIdIn(Collection<String> ids);




}
