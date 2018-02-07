package controller;

import com.sun.deploy.net.HttpResponse;
import entity.UserInformation;
import jdbcTest.jdbctest;
import org.json.JSONArray;
import org.omg.IOP.Encoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.QqService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/QQ")
public class QqController {
    @Autowired
    private QqService qqServiceImpl;

    @RequestMapping(value = "/getmessage",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getmessage(String username1, String username2, HttpServletResponse response
    , HttpSession session) throws UnsupportedEncodingException {
      /* response.setHeader("Cache-Control","no-cache");*/
  /*     response.setContentType("text/json;charset=UTF-8");*/
/*       response.setCharacterEncoding("UTF-8");*/
        System.out.println("username1:"+username1);
        System.out.println("username2:"+username2);
        session.setAttribute("loginuserpattern",username2);
        System.out.println(session.getAttribute("loginuserpattern"));
        String result = qqServiceImpl.queryByName(username1,username2);
        System.out.println(result);
     /*   List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        System.out.println(list.toString());
        String s = list.toString().substring(1,list.toString().length()-1);
        System.out.println(s);*/
        return result;
    }

    @RequestMapping(value = "/getperson",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getperson(String username){
        System.out.println("姓名:"+username);
        List<String> list = qqServiceImpl.queryByUser(username);
        if(list==null){
            System.out.println("读取数据失败");
        }
        System.out.println(list.toString().trim());
        String s = list.toString().substring(1,list.toString().length()-1);
        System.out.println(s.trim());
        return s;
    }

    @RequestMapping(value = "/updatecontext",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void updatecontext(String context,String name1,String name2){
        System.out.println("修改之后的数据:"+context);
        System.out.println("name1:"+name1);
        System.out.println("name2:"+name2);;
        qqServiceImpl.updatecontext(name1,name2,context);
        System.out.println("结束");
    }

    @RequestMapping(value = "/information",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getinformatonbyid(String serchid){
        System.out.println("进入了后台");
        jdbctest jdbctest1 = new jdbctest();
        ArrayList<UserInformation> userInformationArrayList = jdbctest1.GetInformatonById(serchid);
        for(int i=0;i<userInformationArrayList.size();i++) {
            System.out.println(userInformationArrayList.get(i));
        }
        JSONArray jsonArray = new JSONArray(userInformationArrayList);
        System.out.println("json格式:"+jsonArray.toString());
        return  jsonArray.toString();
    }
}
