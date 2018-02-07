package service;

import dao.LoginUserMapper;
import entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    private LoginUserMapper loginUserMapper;
    public List<LoginUser> LoginUserList(LoginUser u){
        if(u!=null&&u.getUsername()!=null && !"".equals(u.getUsername().trim())){
            u.setUsername( "%"+u.getUsername()+"%");
        }
        if(u!=null&&u.getName()!=null && !"".equals(u.getName().trim())){
            u.setName( "%"+u.getName()+"%");
        }
        return  loginUserMapper.LoginUserList(u);
    }
    public void AddLoginUser(LoginUser user){
        loginUserMapper.AddLoginUser(user);
    }

    public List<LoginUser> LoginByUser(LoginUser u) {

        return loginUserMapper.LoginByUser(u);
    }

}
