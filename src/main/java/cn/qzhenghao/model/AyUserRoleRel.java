package cn.qzhenghao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 14:53
 */

@Entity
@Table(name = "ay_users_role_rel")
@Data
public class AyUserRoleRel {
    @Id
    private String userId;
    private String roleId;
}
