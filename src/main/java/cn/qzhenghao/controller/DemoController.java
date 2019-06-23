package cn.qzhenghao.controller;

import cn.qzhenghao.vo.ResultVO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2018/12/10.
 */


@RestController
@RequestMapping("/hello")
public class DemoController {
    @RequestMapping("/picUpload")
    public String picUpload(){
        return "picUpload";
    }
    @PostMapping("/upload")
    public Object upload(MultipartFile fileUpload){
        //获取文件名
         ResultVO result = new ResultVO();
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "D/MyEclipseworkspace/demo/src/resources/static/";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath+fileName));

            result.setCode(0);
            result.setMsg("success");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1000);
            result.setMsg("jj");
            return result;
        }
    }

    @RequestMapping("/ay")
    public String index() {
        return "Hello Ay...";
    }
}



