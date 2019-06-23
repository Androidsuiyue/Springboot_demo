package cn.qzhenghao.security;

import cn.qzhenghao.error.BussinessException;
import cn.qzhenghao.model.AyUserRoleRel;
import cn.qzhenghao.model.User;
import cn.qzhenghao.service.AyRoleService;
import cn.qzhenghao.service.AyUserRoleRelService;
import cn.qzhenghao.service.AyUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suiyue
 * @description 返回当前Authentication对象拥有的权限，即当前用户拥有的权限。其返回值是
 *              一个GrantedAuthority类型的数组，每一个GrantedAuthority对象代表赋予给
 *              当前用户的一种权限。GrantedAuthority是一个接口，其通常是通过UserDetailsService
 *              进行加载，然后赋予给UserDetails的。
 * @date 2019/1/12 15:18
 */
public class CustomUserService implements UserDetailsService {
    @Resource
    private AyUserRoleRelService ayUserRoleRelService;
    @Resource
    private AyRoleService ayRoleService;
    @Resource
    private AyUserService ayUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> byName = ayUserService.findByName(s);
        User user = byName.get(0);
        if (user == null) {
            throw new BussinessException();
        }
        List<AyUserRoleRel> byUserId = ayUserRoleRelService.findByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //获取用户关联角色名称
        if (byUserId != null && byUserId.size() > 0) {
            for (AyUserRoleRel roleRel :
                    byUserId) {
                String name = ayRoleService.find(roleRel.getRoleId()).getName();
                grantedAuthorities.add(new SimpleGrantedAuthority(name));

            }
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),grantedAuthorities);
    }
}
