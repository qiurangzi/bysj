package com.cm.service;

import com.cm.dao.CusUserMapper;
import com.cm.model.CusUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangtianfeng on 2018/12/5.
 */
@Service
public class CusUserService {
    @Autowired
    CusUserMapper cusUserMapper;

    public CusUser checkPhone(Map<String, Object> paramMap) {
        return cusUserMapper.checkPhone(paramMap);
    }

    public void reg(Map<String, Object> paramMap) {
        cusUserMapper.reg(paramMap);
    }

    public CusUser selectLogin(Map<String, Object> paramMap) {
        return cusUserMapper.selectLogin(paramMap);
    }
}
