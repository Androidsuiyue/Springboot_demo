//package cn.qzhenghao.controller;
//
//import cn.binarywang.wx.miniapp.api.WxMaService;
//import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
//import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
//import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
//import cn.qzhenghao.config.WxMaConfiguration;
//import cn.qzhenghao.utils.HttpClientUtil;
//import cn.qzhenghao.utils.JsonUtils;
//import cn.qzhenghao.utils.WechatGetUserInfoUtil;
//import cn.qzhenghao.vo.ResultVO;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import me.chanjar.weixin.common.error.WxErrorException;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * 微信小程序用户接口
// *
// * @author <a href="https://github.com/binarywang">Binary Wang</a>
// */
//@RestController
//@RequestMapping("/wx/user/{appid}")
//public class UserController {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * 登陆接口
//     */
//    @GetMapping("/login")
//    public String login(@PathVariable String appid, String code) {
//        if (StringUtils.isBlank(code)) {
//            return "empty jscode";
//        }
//
//        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
//
//        try {
//            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
//            this.logger.info(session.getSessionKey());
//            this.logger.info(session.getOpenid());
//            //TODO 可以增加自己的逻辑，关联业务相关数据
//            return JsonUtils.toJson(session);
//        } catch (WxErrorException e) {
//            this.logger.error(e.getMessage(), e);
//            return e.toString();
//        }
//    }
//
//    /**
//     * d登录接口
//     * @param encryptedData
//     * @param iv
//     * @param code
//     * @return
//     */
//    @PostMapping("/onLogin")
//    public ResultVO login(String encryptedData, String iv, String code) {
//        String appid="wxbf4a143fe7c49e5e";
//        String appSecret="abeaf45e51afdee1712c574af037a06d";
//
//        ResultVO result = new ResultVO();
//        if(!StringUtils.isNotBlank(code)){
//            result.setCode(0);
//            result.setMsg("未获取到用户凭证code");
//            return result;
//
//        }
//        String apiUrl="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code";
//        System.out.println(apiUrl);
//        String responseBody = HttpClientUtil.doGet(apiUrl);
//        System.out.println(responseBody);
//        JSONObject jsonObject = JSON.parseObject(responseBody);
//        if(StringUtils.isNotBlank(jsonObject.getString("openid"))&&StringUtils.isNotBlank(jsonObject.getString("session_key"))){
//            //解密获取用户信息
//            JSONObject userInfoJSON= WechatGetUserInfoUtil.getUserInfo(encryptedData,jsonObject.getString("session_key"),iv);
//            if(userInfoJSON!=null){
//                //这步应该set进实体类
//                Map userInfo = new HashMap();
//                userInfo.put("openId", userInfoJSON.get("openId"));
//                userInfo.put("nickName", userInfoJSON.get("nickName"));
//                userInfo.put("gender", userInfoJSON.get("gender"));
//                userInfo.put("city", userInfoJSON.get("city"));
//                userInfo.put("province", userInfoJSON.get("province"));
//                userInfo.put("country", userInfoJSON.get("country"));
//                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
//                // 解密unionId & openId;
//                if (userInfoJSON.get("unionId")!=null) {
//                    userInfo.put("unionId", userInfoJSON.get("unionId"));
//                }
//                //然后根据openid去数据库判断有没有该用户信息，若没有则存入数据库，有则返回用户数据
//                Map<String,Object> dataMap = new HashMap<>();
//                dataMap.put("userInfo", userInfo);
//                String uuid= UUID.randomUUID().toString();
//                dataMap.put("WXTOKEN", uuid);
//                redisTemplate.opsForValue().set(uuid,userInfo);
//                redisTemplate.expire(uuid,appTimeOut, TimeUnit.SECONDS);
//                result.setCode(0);
//                result.setMsg("success");
//                result.setData(dataMap);
//                return result;
//            }else{
//                result.setCode(0);
//                result.setMsg("解密失败");
//                return result;
//            }
//        }else{
//            result.setCode(0);
//            result.setMsg("未获取到用户openid 或 session");
//            return result;
//        }
//    }
//
//}
