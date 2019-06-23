package cn.qzhenghao.service;

import cn.qzhenghao.model.AyUserRoleRel;

import java.util.List;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 15:10
 */
public interface AyUserRoleRelService {
    List<AyUserRoleRel> findByUserId(String userid);
}
