package cn.qzhenghao.dao;

import cn.qzhenghao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



/**
 * Created by Administrator on 2018/12/25.
 */
@Mapper
public interface AyUserMapper {
//      @Select("SELECT *  FROM ay_user WHERE name='name' AND password='password'")
    //Param注意是哪个包的
      User findByNameAndPassword(@Param("name") String name,@Param("password") String password);
}