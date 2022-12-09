package com.kuang.service;

import com.kuang.dao.PaperMapper;
import com.kuang.dao.UserMapper;
import com.kuang.pojo.Login_return;
import com.kuang.pojo.Paper;
import com.kuang.pojo.Signup_return;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

//    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private  PaperMapper paperMapper;

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByEmail(String email) {

        return userMapper.queryUserByEmail(email);
    }

    @Override
    public Login_return checkUserLog(String email, String pwd) {
        Login_return login_return = new Login_return();
        if(userMapper.checkEmail(email) == 0)
        {
            login_return.setLogCheckFlag(false);
            login_return.setLogCheckDetail("用户不存在，请注册");
        }
        else
        {
            if(userMapper.checkLogin(email,pwd) == 0)
            {
                login_return.setLogCheckFlag(false);
                login_return.setLogCheckDetail("密码错误，请重试");
            }
            else
            {
                login_return.setLogCheckFlag(true);
                login_return.setLogCheckDetail("登录成功");
            }
        }
        return login_return;
    }

    @Override
    public List<User> queryUserBySearch(String str) {
        return userMapper.queryUserBySearch(str);
    }

    @Override
    public List<User> queryUserLinkTo(int id) {

        return userMapper.queryUserLinkTo(id);
    }

    @Override
    public List<User> queryUserLinkFrom(int id) {
        return userMapper.queryUserLinkFrom(id);
    }

    @Override
    public int queryUserLink(int userId1, int userId2) {
        return userMapper.queryUserLink(userId1,userId2);
    }

    @Override
    public boolean queryUserPaperLink(int userId, int paperId) {
        return userMapper.queryUserPaperLink(userId,paperId)!=0;
    }

    @Override
    public Signup_return addUser(String email, String pwd) {

        Signup_return signup_return = new Signup_return();

        User user = new User();
        user.setPwd(pwd);
        user.setName(email);

        if(userMapper.checkEmail(email)!=0)
        {
            signup_return.setSignCheckFlag(false);
            signup_return.setSignCheckDetail("用户已存在，请登录");
        }
        else
        {
            if(userMapper.addUser(user)==0)
            {
                signup_return.setSignCheckFlag(false);
                signup_return.setSignCheckDetail("未知原因，请重试");
            }
            else
            {
                signup_return.setSignCheckFlag(true);
                signup_return.setSignCheckDetail("注册成功");
            }
        }

        return signup_return;

    }

    @Override
    public int updateUser(User user) {

        userMapper.updateUser(user);

        return 1;
    }

    @Override
    public int updateUserLink(int userId1, int userId2, boolean type) {
        //取消关注
        if(type = true)
        {
            userMapper.deleteUserUserLink(userId1,userId2);
            return 1;
        }
        //开启关注
        else if(type = false)
        {
            userMapper.insertUserUserlink(userId1,userId2);
            return 1;
        }
        return 0;
    }


    @Override
    public boolean updateUserPaperLink(int userId, int paperId, boolean type) {
        //取消收藏
        if(type == true)
        {
            userMapper.deleteUserPaperLink(userId,paperId);
            return true;
        }
        //开启收藏
        else if(type == false)
        {
            userMapper.insertUserPaperLink(userId,paperId);
            return true;
        }

        return false;
    }

    @Override
    public List<Paper> queryUserPaperInfo(int id) {
        List<Paper> list = paperMapper.allPaper();
        List<Paper> re = new ArrayList<>();
        for(Paper paper : list){
            if(queryUserPaperLink(id, paper.getPaperId())){
                re.add(paper);
            }
        }
        return re;
    }
}
