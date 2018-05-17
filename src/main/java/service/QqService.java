package service;

import java.util.List;

public interface QqService {
    String queryByName(String name1,String name2);
    List<String> queryByUser(String username);
    void updatecontext(String name1,String name2,String context);
    String getPersonByName(String searchName);
    void addFriendByName(String searchName1,String searchName2);
    void addQqMessage(String name1,String name2);
    void register(String username,String password,String realname);
}
