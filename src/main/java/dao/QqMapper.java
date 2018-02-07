package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QqMapper {
    String queryByName(Map<String,String> map);
    List<String> queryByUser(String username);
    void udatecontext(Map<String,String> map);
}
