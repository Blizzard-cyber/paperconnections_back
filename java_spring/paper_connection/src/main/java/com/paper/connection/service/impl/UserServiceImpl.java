package com.paper.connection.service.impl;

import com.paper.connection.dao.PaperDao;
import com.paper.connection.dao.UserDao;
import com.paper.connection.pojo.LoginReturn;
import com.paper.connection.pojo.Paper;
import com.paper.connection.pojo.SignupReturn;
import com.paper.connection.pojo.User;
import com.paper.connection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    @Autowired
    private UserDao userDao;

    @Autowired
    private PaperDao paperDao;


    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public LoginReturn checkUserLog(String email, String pwd) {
        LoginReturn login_return = new LoginReturn();
        if(userDao.checkEmail(email) == 0)
        {
            login_return.setLogCheckFlag(false);
            login_return.setLogCheckDetail("用户不存在，请注册");
        }
        else
        {
            if(userDao.checkLogin(email,pwd) == 0)
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
        return userDao.queryUserBySearch(str);
    }

    @Override
    public List<User> queryUserLinkTo(int id) {

        return userDao.queryUserLinkTo(id);
    }

    @Override
    public List<User> queryUserLinkFrom(int id) {
        return userDao.queryUserLinkFrom(id);
    }


    @Override
    public boolean queryUserPaperLink(int userId, int paperId) {
        return userDao.queryUserPaperLink(userId,paperId)!=0;
    }

    @Override
    public SignupReturn addUser(String email, String pwd) {

        SignupReturn signup_return = new SignupReturn();

        User user = new User();
        user.setPwd(pwd);
        user.setName(email);

        if(userDao.checkEmail(email)!=0)
        {
            signup_return.setSignCheckFlag(false);
            signup_return.setSignCheckDetail("用户已存在，请登录");
        }
        else
        {
            if(userDao.addUser(user)==0)
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
    public int updateUserLink(int userId1, int userId2, boolean type) {
        //取消关注
        if(type == true)
        {
            userDao.deleteUserUserLink(userId1,userId2);
            return 1;
        }
        //开启关注
        else if(type == false)
        {
            userDao.insertUserUserlink(userId1,userId2);
            return 1;
        }
        return 0;
    }


    @Override
    public boolean updateUserPaperLink(int userId, int paperId, boolean type) {
        //取消收藏
        if(type == true)
        {
            userDao.deleteUserPaperLink(userId,paperId);
            return true;
        }
        //开启收藏
        else if(type == false)
        {
            userDao.insertUserPaperLink(userId,paperId);
            return true;
        }

        return false;
    }

    @Override
    public List<Paper> queryUserPaperInfo(int id) {
        List<Paper> list = paperDao.allPaper();
        List<Paper> re = new ArrayList<>();
        for(Paper paper : list){
            if(queryUserPaperLink(id, paper.getPaperId())){
                re.add(paper);
            }
        }
        return re;
    }
}
