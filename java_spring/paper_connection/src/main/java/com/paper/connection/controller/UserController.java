package com.paper.connection.controller;

import com.paper.connection.pojo.LoginReturn;
import com.paper.connection.pojo.Paper;
import com.paper.connection.pojo.SignupReturn;
import com.paper.connection.pojo.User;
import com.paper.connection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //测试连接接口
    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public User test(@PathVariable("id") String id){
//        System.out.println("hello");
        User user = new User(1,"John","John123");
        return user;
    }

    //1.2用户收藏文章功能接口
    @RequestMapping(value = "/userPaper/{userId}/{paperId}/{flag}", method = RequestMethod.POST)
    public boolean userCollectPaper(@PathVariable("userId") int userId, @PathVariable("paperId") int paperId, @PathVariable("flag") boolean flag){
        return userService.updateUserPaperLink(userId,paperId,flag);
    }

    //2.1登录接口 返回值两种类型存在Login_return实体类中
    @RequestMapping(value = "/singIn/{email}/{passwd}", method = RequestMethod.POST)
    public LoginReturn login(@PathVariable("email") String email, @PathVariable("passwd") String passwd) {

        return userService.checkUserLog(email,passwd);
    }

    //2.2注册接口 返回值两种类型存在Signup_return实体类中
    @RequestMapping(value = "/singUp/{email}/{passwd}", method = RequestMethod.POST)
    public SignupReturn signup(@PathVariable("email") String email, @PathVariable("passwd") String passwd)
    {
        return userService.addUser(email,passwd);
    }

    //4.1用户页面接口 & 5.2用户查询接口
    @RequestMapping(value = "/userInfo/{id}", method = RequestMethod.GET)
    public User userHomepage(@PathVariable("id") int id)
    {
        return userService.queryUserById(id);
    }

    //4.2用户收藏文章界面接口
    @RequestMapping(value = "/userPaperInfo/{id}", method = RequestMethod.GET)
    public List<Paper> userPaperCollectionPage(@PathVariable("id") int id)
    {
        return userService.queryUserPaperInfo(id);
    }

    //4.3用户关注用户界面接口
    @RequestMapping(value = "/userLinkInfo/{type}/{id}", method = RequestMethod.GET)
    public List<User> userUserCollectionPage(@PathVariable("id") int id, @PathVariable("type") int type)
    {
        if(type == 0)
        {
            return userService.queryUserLinkTo(id);
        }
        else if(type == 1)
        {
            return userService.queryUserLinkFrom(id);
        }
        return null;
    }

    //4.4用户关注用户功能接口
    @RequestMapping(value = "/userLinkInfo/{type}/{id1}/{id2}", method = RequestMethod.GET)
    public void userCollectUser(@PathVariable("type") boolean type, @PathVariable("id1") int id1, @PathVariable("id2") int id2)
    {
        userService.updateUserLink(id1,id2,type);
    }

    //5.1搜索用户功能接口
    @RequestMapping(value = "userSearch/{searchString}", method = RequestMethod.GET)
    public List<User> userSearchUser(@PathVariable("searchString") String searchString)
    {
        return userService.queryUserBySearch(searchString);
    }
}
