package com.zzg.ajax.dao;

import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public interface AdminDAO {
    Map<String, Object> login(String username, String password);
}
