package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.LoginUserServiceImpl;

import javax.servlet.http.HttpServlet;

@Controller
public class CommonController {

    @Autowired
    private LoginUserServiceImpl loginUserService;

    //过一段时间把这个隔离掉，放在其他的文件夹里面
    @RequestMapping(value = "/{forname}")
    public String common(@PathVariable String forname){
        return forname;
    }
}
