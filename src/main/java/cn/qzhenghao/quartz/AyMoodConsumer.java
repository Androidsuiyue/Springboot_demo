package cn.qzhenghao.quartz;

import cn.qzhenghao.model.AyMood;
import cn.qzhenghao.repository.AyMoodRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author suiyue
 * @ClassName AyMoodConsumer
 * @Description TODO
 * @date 2019/1/2 13:14
 */
@Component
public class AyMoodConsumer {
    @Resource
    private AyMoodRepository ayMoodReposiory;
    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text){
        System.out.println("用户发表说说【"+text+"】");

    }
    @JmsListener(destination = "ay.queue.ayyn.save")
    public void receiveQueue(AyMood ayMood){
        ayMoodReposiory.save(ayMood);
    }






}

