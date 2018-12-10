package com.cm.controller;

import com.cm.model.CusUser;
import com.cm.service.CusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangtianfeng on 2018/12/5.
 */
@Controller
public class CusUserController {
    @Autowired
    private CusUserService cusUserService;

    @RequestMapping(value="cusUser/say",method = RequestMethod.POST)
    @ResponseBody
    public String say() {
      return "hello world";
    }

    @RequestMapping(value="cusUser/reg",method = RequestMethod.POST)
    @ResponseBody
    public Map reg(
            String userName
            ,String userPass
            ,String phoneNo
    ) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("userName",userName);
        paramMap.put("userPass",userPass);
        paramMap.put("phoneNo",phoneNo);
        Map<String,Object> resultMap=new HashMap<>();
        CusUser cusUser=cusUserService.checkPhone(paramMap);
        if(cusUser!=null){
            resultMap.put("info","手机号已存在");
            return resultMap;
        }
        cusUserService.reg(paramMap);
        resultMap.put("info","成功");
        return resultMap;
    }

    @RequestMapping(value="cusUser/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(
            String userName
            ,String userPass
    ) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("userName",userName);
        paramMap.put("userPass",userPass);
        Map<String,Object> resultMap=new HashMap<>();
        CusUser cusUser=cusUserService.selectLogin(paramMap);
        if(cusUser!=null){
            resultMap.put("data",cusUser);
            resultMap.put("info","成功");
        }else{
            resultMap.put("info","该用户未注册");
        }
        return resultMap;

    }

}
