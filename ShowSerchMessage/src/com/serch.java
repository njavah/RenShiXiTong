package com;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class serch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是后台程序");
        String context = req.getParameter("keyword");
        System.out.println(context);
        JSONObject jsonObject = new JSONObject("{\"a\":\"b\", \"c\":\"d\"}");
        System.out.println(jsonObject);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
