package JunitTest;


import entity.NowFriend;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;


@RunWith(BlockJUnit4ClassRunner.class)
public class BaseTest {
    @Test
    public void say(){
        Configuration configuration = new Configuration();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.getMapper();
    }
    @Test
    public void say_1(){
        NowFriend nowFriend = new NowFriend("zhangsan","admin");
        NowFriend nowFriend1 = new NowFriend("zhangsan","admin");
        NowFriend nowFriend2 = new NowFriend("admin","zhangsan");
        HashMap<NowFriend,Integer> hashMap = new HashMap<NowFriend, Integer>();
        System.out.println(nowFriend.equals(nowFriend1));
        hashMap.put(nowFriend,0);
        hashMap.put(nowFriend1,1);
    }

    @Test
    public void test_1(){
       HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
       hashMap.put(1,1);
       hashMap.put(2,2);
       System.out.println(hashMap.size());
       HashMap<Integer,Integer> hashMap1 = new HashMap<Integer, Integer>(hashMap);
       hashMap.remove(1);
        System.out.println(hashMap.size());
        System.out.println(hashMap1.size());
    }

    public static void main(String[] args) {


    }
}
