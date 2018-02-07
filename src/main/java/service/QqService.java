package service;

import java.util.List;

public interface QqService {
    String queryByName(String name1,String name2);
    List<String> queryByUser(String username);
    void updatecontext(String name1,String name2,String context);
}
