package cn.qzhenghao.controller;

import cn.qzhenghao.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/17.
 */
@RestController
@RequestMapping("/test1")
public class TestController {
    @RequestMapping("/test1")
    public ResultVO test() {
        ResultVO result = new ResultVO();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }
}
