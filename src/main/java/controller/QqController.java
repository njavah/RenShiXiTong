package controller;

import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.NowFriend;
import entity.UserInformation;
import jdbcTest.jdbctest;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONString;
import org.omg.IOP.Encoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.QqService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/QQ")
public class QqController {
    @Autowired
    private QqService qqServiceImpl;
  //  private Logger logger = Logger.getLogger(QqController.class);
    private static  int count = 0;
    private String result = "";
    private HashMap<NowFriend,Integer> notReadNumber = new HashMap<NowFriend, Integer>();
   // private NowFriend nowTimeFriend;
    @RequestMapping(value = "/getmessage",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getmessage(String username1, String username2, HttpServletResponse response
    , HttpSession session) throws UnsupportedEncodingException {

        session.setAttribute("loginuserpattern",username2);
        NowFriend nowFriend = new NowFriend(username1,username2);

        if(notReadNumber.containsKey(nowFriend)){
            nowFriend = getFriend(nowFriend);
            if(nowFriend.getUserCount()==0){
                result = qqServiceImpl.queryByName(username1,username2);
                nowFriend.setResult(result);
                nowFriend.setUserCount(1);
            }
            else{
                result = nowFriend.getResult();
            }
        }
        else{
            result = qqServiceImpl.queryByName(username1,username2);
            notReadNumber.put(nowFriend,0);
            nowFriend.setUserCount(1);
            nowFriend.setResult(result);
        }
        clearNumber(username1,username2);
      //  System.out.println("getmessage:"+result);
         return result;
    }

    private void clearNumber(String username1,String username2){
        NowFriend nowFriend = new NowFriend(username2,username1);
        if(notReadNumber.containsKey(nowFriend)){
            nowFriend = getFriend(nowFriend);
            notReadNumber.put(nowFriend,0);
        }
    }

    public NowFriend getFriend(NowFriend nowFriend){
        NowFriend result = null;
        Set<NowFriend> set = notReadNumber.keySet();
        Iterator<NowFriend> iterator = set.iterator();
        while (iterator.hasNext()){
            result = iterator.next();
            if(result.equals(nowFriend)){
                return result;
            }
        }

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
        System.out.println("name2:"+name2);
        qqServiceImpl.updatecontext(name1,name2,context);
        result = context;
        NowFriend nowFriend = new NowFriend(name1,name2);
        NowFriend nowFriend1 = new NowFriend(name2,name1);
        if(notReadNumber.containsKey(nowFriend)){
            nowFriend = getFriend(nowFriend);
            nowFriend.setResult(result);
            notReadNumber.put(nowFriend,notReadNumber.get(nowFriend)+1);
        }
        else{
            notReadNumber.put(nowFriend,1);
            nowFriend.setResult(result);
        }
        nowFriend1 = getFriend(nowFriend1);
        if(nowFriend1!=null){
            nowFriend1.setResult(result);
            notReadNumber.put(nowFriend1,notReadNumber.get(nowFriend1));
        }else{
            nowFriend1 = new NowFriend(name2,name1);
            nowFriend1.setResult(result);
            notReadNumber.put(nowFriend1,0);
        }
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

    @RequestMapping(value = "/getPersonByName",produces = "text/html;charset=UTF-8" )
    @ResponseBody
    public String getPersonByName(String Name){
      //  Logger logger = Logger.getLogger(QqController.class);
        System.out.println("查询的名字:"+Name);
        String resultName = "";
        if(Name==null)Name="";

        resultName = qqServiceImpl.getPersonByName(Name);
        return resultName;
    }

    @RequestMapping(value ="/addFriendByName",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void addFriendByName(String searchName1,String searchName2){
        System.out.println("searchname:"+searchName1+"  "+searchName2);
        qqServiceImpl.addFriendByName(searchName1,searchName2);
        qqServiceImpl.addQqMessage(searchName1,searchName2);
    }

    @RequestMapping(value = "/nowNotReadMessage",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String nowNotReadMessage(String name){
        String s = "{"+"\"namelist\":[";
        Set<NowFriend> set = notReadNumber.keySet();
        Iterator<NowFriend> iterator = set.iterator();
        while(iterator.hasNext()){
            NowFriend nowFriend = iterator.next();
            if(nowFriend.getUserName2().equals(name)){//表示有人给name发消息
                s = s+"{\"name\":\""+nowFriend.getUserName1()+"\",\"num\":\""+notReadNumber.get(nowFriend)+"\"},";
            }
        }
        return  s.substring(0,s.length()-1)+"]}";
    }

    @RequestMapping(value ="/register")
    public ModelAndView register(  String username,  String password,  String realName){
        System.out.println(username+"  "+password+"  "+password);
        ModelAndView modelAndView = new ModelAndView();
      //  qqServiceImpl.register(username,password,realName);

        return modelAndView;

    }
}
