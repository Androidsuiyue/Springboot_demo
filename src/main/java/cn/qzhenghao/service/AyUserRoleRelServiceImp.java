package cn.qzhenghao.service;

import cn.qzhenghao.model.AyUserRoleRel;
import cn.qzhenghao.repository.AyUserRoleRelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 15:15
 */
@Service
public class AyUserRoleRelServiceImp implements AyUserRoleRelService {
    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;
    @Override
    public List<AyUserRoleRel> findByUserId(String userid) {

        return ayUserRoleRelRepository.findByUserId(userid);
    }
}
