package cn.qzhenghao.repository;

import cn.qzhenghao.model.AyRole;
import cn.qzhenghao.model.AyUserRoleRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 14:59
 */
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel, String> {

    List<AyUserRoleRel> findByUserId(@Param("userId") String userId);
}
