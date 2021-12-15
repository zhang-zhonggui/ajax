package com.zzg.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.ajax.dao.StudentDAO;
import com.zzg.ajax.dao.impl.StudentDAOImpl;
import com.zzg.ajax.result.AJAXResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/stu/s")
public class StudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("inquireStu")) {
            inquireStu(req, resp);
        }
    }

    protected void inquireStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Map<String, Object>> list = studentDAO.list();
        AJAXResult result = new AJAXResult(20000,"查询成功",list);
        String s = JSON.toJSONString(result);
        PrintWriter out = resp.getWriter();
    }
}
