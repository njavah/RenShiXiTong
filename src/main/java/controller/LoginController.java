package controller;

import entity.LoginUser;
import jdbcTest.jdbctest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.LoginUserService;
import service.LoginUserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginUserService loginUserServiceImpl;

    @RequestMapping(value = "/adduser")
    public ModelAndView adduser(@ModelAttribute LoginUser loginUser,ModelAndView mv){
        loginUserServiceImpl.AddLoginUser(loginUser);
        mv.addObject("message","添加用户成功");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping(value = "/queryuser")
    public ModelAndView queryuser(ModelAndView mv,@ModelAttribute LoginUser loginUser){
       List<LoginUser> loginuserList = loginUserServiceImpl.LoginUserList(loginUser);
       mv.addObject("loginuserList",loginuserList);
       mv.setViewName("queryuser");
       return mv;
    }
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password,
                              ModelAndView mv, HttpSession session){
        Logger log = Logger.getLogger(LoginController.class);
        LoginUser user = new LoginUser();
        user.setPassword(password);
        user.setUsername(username);
        System.out.println("username:"+username);
        System.out.println("passoword:"+password);
       // jdbctest jdbctest1 = new jdbctest();
        System.out.println(loginUserServiceImpl);
        List<LoginUser> loginUserList = loginUserServiceImpl.LoginByUser(user);
        System.out.println(loginUserList.size());
        if(loginUserList!=null&&loginUserList.size()>=1){
            mv.setViewName("QQ");
            session.setAttribute("loginuser",username);
        }
        else{
            mv.setViewName("loginform");
            session.setAttribute("message","用户名或密码错误");
        }
        return mv;
    }

}
