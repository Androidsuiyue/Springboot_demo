package cn.qzhenghao.model;

import lombok.Data;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author suiyue
 * @ClassName AyMood
 * @Description TODO
 * @date 2018/12/26 20:24
 */
@Entity
@Data
@Table(name="ay_mood")
public class AyMood  implements Serializable{

    @Id
    private String id;

    private String content;
    private String userId;
    private Integer praiseNum;
    private Date publishTime;

}
