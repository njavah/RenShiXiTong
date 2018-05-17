package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QqMapper {
    String queryByName(Map<String,String> map);
    List<String> queryByUser(String username);
    void udatecontext(Map<String,String> map);
    String getPersonByName(String searchName);
    void addFriendByName(Map<String,String> map);
    void addQqMessage(Map<String,String> map);
    void register(Map<String,String> map);
}
