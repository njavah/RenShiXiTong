package entity;

//登陆用户实例
public class LoginUser {
    //登陆用户名
    private String username;
    //登陆密码
    private String password;
    //姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        LoginUser u = (LoginUser)obj;
        if(u.getUsername().trim().equals(username.trim())&&u.getPassword().trim().equals(password.trim())){
            return true;
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
