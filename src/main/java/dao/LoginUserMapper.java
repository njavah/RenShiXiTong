package dao;

import entity.LoginUser;

import java.util.List;

public interface LoginUserMapper {
    public List<LoginUser> LoginUserList(LoginUser u);
    public void AddLoginUser(LoginUser user);
    List<LoginUser> LoginByUser(LoginUser u);
}
