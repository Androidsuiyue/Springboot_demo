package cn.qzhenghao.service;

import cn.qzhenghao.model.AyUserAttachmentRel;
import cn.qzhenghao.repository.AyUserAttachmentRelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author suiyue
 * @date 2019/1/11 17:06
 */
@Service
public class AyUserAttachmentRelServiceimp implements AyUserAttachmentRelService{

    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;
    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}

