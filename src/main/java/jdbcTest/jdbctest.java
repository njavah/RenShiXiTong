package jdbcTest;

import entity.LoginUser;
import entity.UserInformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbctest {
    public List<LoginUser> LoginByUser(LoginUser user){

        List<LoginUser> loginUserList = new ArrayList<LoginUser>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;DatabaseName=RenShiXiTong";
            String username="sa";
            String password="n12345";
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stat = conn.createStatement();
            String sql="select * from loginuser where username='"+user.getUsername()+"' and " +
                    "password='"+user.getPassword()+"'";
            System.out.println("sql:"+sql);
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                LoginUser u1 = new LoginUser();
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                loginUserList.add(u1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginUserList;
    }

    public ArrayList<UserInformation> GetInformatonById(String id){
        ArrayList<UserInformation> userInformationList = new ArrayList<UserInformation>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;DatabaseName=RenShiXiTong";
            String username="sa";
            String password="n12345";
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stat = conn.createStatement();
            String sql="select * from userinformation where id="+id;
            if(id==null||id.equals(""))
                sql="select * from userinformation";
            System.out.println("sql:"+sql);
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                UserInformation u1 = new UserInformation();
                u1.setId(rs.getString("id"));
                u1.setUsername(rs.getString("username"));
                userInformationList.add(u1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List的size():"+userInformationList.size());
        System.out.println(userInformationList.toString());
        for(int i=0;i<userInformationList.size();i++){
            System.out.println(userInformationList.get(i));
        }
        return userInformationList;
    }
}
