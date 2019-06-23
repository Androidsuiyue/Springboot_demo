package cn.qzhenghao.service;

import cn.qzhenghao.model.AyMood;
import cn.qzhenghao.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/12/12.
 */

public interface AyMoodService {
    AyMood save(AyMood ayMood);
    List<AyMood> findAll();
    String asynSave(AyMood ayMood);

}

