package service;

import dao.QqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QqServiceImpl implements   QqService {
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

    public String getPersonByName(String searchName) {
        System.out.println("进入service层查询");
        return qqMapper.getPersonByName(searchName);
    }

    public void addFriendByName(String searchName1,String searchName2) {
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("searchName1",searchName1);
        hashMap.put("searchName2",searchName2);
        qqMapper.addFriendByName(hashMap);
    }
    public void addQqMessage(String name1,String name2){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("name1",name1);
        hashMap.put("name2",name2);
        qqMapper.addQqMessage(hashMap);
    }

    public void register(String username, String password,String realname) {
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("username",username);
        hashMap.put("password",password);
        hashMap.put("realname",realname);
        qqMapper.register(hashMap);
    }

}
