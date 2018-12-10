package com.cm.dao;

import com.cm.model.CusUser;
import java.util.List;
import java.util.Map;

public interface CusUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(CusUser record);

    CusUser selectByPrimaryKey(Integer userId);

    List<CusUser> selectAll();

    int updateByPrimaryKey(CusUser record);

    CusUser checkPhone(Map<String, Object> paramMap);

    void reg(Map<String, Object> paramMap);

    CusUser selectLogin(Map<String, Object> paramMap);
}