package cn.qzhenghao.service;


import cn.qzhenghao.model.AyMood;
import cn.qzhenghao.quartz.AyMoodProducer;
import cn.qzhenghao.repository.AyMoodRepository;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/12.
 */
@Service
public class AyMoodServiceimp implements AyMoodService,Serializable {
    @Resource
    public AyMoodRepository ayMoodReposiory;

    @Override
    public AyMood save(AyMood ayMood) {


        return ayMoodReposiory.save(ayMood);
    }

    @Override
    public List<AyMood> findAll() {
        return  ayMoodReposiory.findAll();
    }

    //队列
    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");
    @Resource
    public AyMoodProducer ayMoodProducer;
    @Override
    public String asynSave(AyMood ayMood) {
        ayMoodProducer.sendMessage(destination, ayMood);
        return "success";
    }

}
