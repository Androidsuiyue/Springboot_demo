package cn.qzhenghao.controller;

import cn.qzhenghao.error.BussinessException;
import cn.qzhenghao.model.User;
import cn.qzhenghao.service.AyUserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/12/13.
 */
@RestController
@RequestMapping("/ayUser")
public class AyUserController {

    @Resource
    private AyUserService ayUserService;

    @RequestMapping("/test")
    public String test(Model model) {

        List<User> ayUser = ayUserService.findAll();
        model.addAttribute("users", ayUser);
        return "ayUser";
    }

    @RequestMapping("/findAll")
    public String findALL(Model model) {
        List<User> all = ayUserService.findAll();
        model.addAttribute("users", all);
        throw new BussinessException("业务异常");
    }

    @RequestMapping("/findByNameAndPasswordRetry")
    public String findByNameAndPassword(Model model) {
        User qian = ayUserService.findByNameAndPasswordRetry("qian", "123456");
        model.addAttribute("users", qian);
        return "success";
    }
}
