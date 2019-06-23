package cn.qzhenghao.quartz;


import cn.qzhenghao.model.AyMood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * @author suiyue
 * @ClassName AyMoodProducter
 * @Description TODO
 * @date 2019/1/2 13:07
 */
@Service
public class AyMoodProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    public void sendMessage(Destination destination, AyMood ayMood) {
        jmsMessagingTemplate.convertAndSend(destination, ayMood);
    }
}
