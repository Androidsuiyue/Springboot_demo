package cn.qzhenghao.service;

import cn.qzhenghao.model.AyRole;
import cn.qzhenghao.repository.AyRoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 15:11
 */
@Service
public class AyRoleServiceImp  implements AyRoleService {
    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id) {
        return ayRoleRepository.findOne(id);
    }
}
