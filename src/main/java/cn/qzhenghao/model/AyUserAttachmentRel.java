package cn.qzhenghao.model;

import lombok.Data;

import javax.persistence.Id;


/**
 * @author suiyue
 * @ClassName Ay
 * @Description TODO
 * @date 2019/1/9 22:33
 */

@Data
public class AyUserAttachmentRel {
    @Id
    private String id;
    private String userId;
    private String fileNmae;
}
