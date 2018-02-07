package service;

import entity.LoginUser;

import java.util.List;

public interface LoginUserService {

    List<LoginUser> LoginUserList(LoginUser u);

    void AddLoginUser(LoginUser user);

    List<LoginUser> LoginByUser(LoginUser u);
}
