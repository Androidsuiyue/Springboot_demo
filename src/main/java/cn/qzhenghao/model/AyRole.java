package cn.qzhenghao.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/1/12 14:51
 */
@Data
@Entity
@Table(name = "ay_rolt")
public class AyRole {

    @Id
    private String id;

    private String name;
}
