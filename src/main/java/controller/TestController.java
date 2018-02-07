package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

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
    public String dialog(){
        return "dialog";
    }
}
