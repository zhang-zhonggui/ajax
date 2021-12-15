package com.zzg.ajax.dao.impl;

import com.zzg.ajax.dao.StudentDAO;
import com.zzg.ajax.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Map<String, Object>> list() {
        String sql = "select * from student";
        List<Map<String, Object>> request = DAOUtil.request(sql);
        return request;
    }
}
