package service;

import dao.DeptMapper;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public int adddept(Dept dept) {
        return deptMapper.adddept(dept);
    }

    public List<Dept> querydept(Dept dept) {
        if(dept!=null&&dept.getDeptname()!=null && !"".equals(dept.getDeptname().trim())){
            dept.setDeptname("%"+dept.getDeptname()+"%");
        }
        return  deptMapper.querydept(dept);
    }
}
