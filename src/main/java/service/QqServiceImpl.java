package service;

import dao.QqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QqServiceImpl implements QqService {
    @Autowired
    private QqMapper qqMapper;
    public String queryByName(String name1, String name2) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name1",name1);
        map.put("name2",name2);
       return qqMapper.queryByName(map);
    }

    public List<String> queryByUser(String username) {
        System.out.println("进入了service层");
        return qqMapper.queryByUser(username);
    }

    public void updatecontext(String name1, String name2,String context) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name1",name1);
        map.put("name2",name2);
        map.put("context",context);
        qqMapper.udatecontext(map);
    }
}
