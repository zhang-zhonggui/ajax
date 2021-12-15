package com.zzg.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.ajax.dao.AdminDAO;
import com.zzg.ajax.dao.impl.AdminDAOImpl;
import com.zzg.ajax.result.AJAXResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private AdminDAO adminDao = new AdminDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("login")) {
            login(req, resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> admin = adminDao.login(username, password);
        if (admin == null) {
            AJAXResult result = new AJAXResult(500001, "对不起账号或密码有误", null);
            String s = JSON.toJSONString(result);
            out.write(s);
        } else {
            req.getSession().setAttribute("admin", admin);

            AJAXResult result = new AJAXResult(200001, "成功登录", null);
            String s = JSON.toJSONString(result);
            out.write(s);
        }
    }
}
