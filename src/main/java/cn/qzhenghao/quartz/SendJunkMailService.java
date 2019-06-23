package cn.qzhenghao.quartz;

import cn.qzhenghao.model.User;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */
public interface SendJunkMailService {
    boolean sendJunkMail(List<User> users) throws MessagingException;




}
