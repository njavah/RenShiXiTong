package entity;

public class NowFriend {
    private String userName1;
    private String userName2;
    private int userCount = 0;
    private String result = "";
    public NowFriend(String userName1,String userName2) {
        this.userName1 = userName1;
        this.userName2 = userName2;
    }
    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  NowFriend){
            return ((NowFriend) obj).userName1.equals(userName1)&&((NowFriend) obj).userName2.equals(userName2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return userName1.hashCode()+userName2.hashCode();
    }
}
