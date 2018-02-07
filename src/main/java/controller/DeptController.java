package controller;

import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.DeptService;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptServiceImpl;

    @RequestMapping("/adddept")
    public ModelAndView adddept(@ModelAttribute Dept dept, ModelAndView mv){
        int i = deptServiceImpl.adddept(dept);
        System.out.println(dept.getDeptname());
        System.out.println(dept.getDeptdescription());
        if(i>0){
            mv.addObject("message","添加部门成功");
            mv.setViewName("success");
        }
        else{
            mv.addObject("message","添加部门失败");
            mv.setViewName("fail");
        }
        return  mv;
    }

    @RequestMapping("/querydept")
    public ModelAndView querydept(ModelAndView mv,@ModelAttribute Dept dept){
       List<Dept> deptList =  deptServiceImpl.querydept(dept);
       mv.addObject("deptlist",deptList);
       mv.setViewName("querydept");
       return  mv;
    }
}
