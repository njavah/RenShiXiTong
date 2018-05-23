package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/test/t1")
public class TestController {
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String test(String user,String Action,String Name){
        System.out.println("user:"+user);
        System.out.println("Action:"+Action);
        System.out.println("Name:"+Name);
        System.out.println("进入到了后端控制器");
        return "This is hou duan kongzhiqi";
    }
    @RequestMapping(value = "/dialog")
    public void dialog(HttpServletResponse response)throws IOException{
      //  response.setCharacterEncoding("utf-8");
        System.out.println("Controller方法中");
       response.getWriter().write("这是requestMapping注解的返回类型为void的dialog方法");
    }

}
