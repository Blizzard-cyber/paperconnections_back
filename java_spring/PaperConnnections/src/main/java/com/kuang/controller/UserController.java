package com.kuang.controller;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.*;
import com.kuang.service.PaperService;
import com.kuang.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Qualifier("userServiceImpl")
    private UserService userService;

    //测试连接接口
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
//        System.out.println("hello");
        return "hello";
    }


    //1.2用户收藏文章功能接口
    @RequestMapping(value = "/userPaper/{userId}/{paperId}/{flag}",method = RequestMethod.GET)
    public boolean user_Collect_Paper(@PathVariable("userId") int userId, @PathVariable("paperId") int paperId, @PathVariable("flag") boolean flag){
        return userService.updateUserPaperLink(userId,paperId,flag);
    }

    //2.1登录接口 返回值两种类型存在Login_return实体类中
    @RequestMapping(value = "/singIn/{email}/{passwd}", method = RequestMethod.POST)
    public Login_return login(@PathVariable("email") String email, @PathVariable("passwd") String passwd) {

        return userService.checkUserLog(email,passwd);
    }

    //2.2注册接口 返回值两种类型存在Signup_return实体类中
    @RequestMapping(value = "/singUp/{email}/{passwd}", method = RequestMethod.POST)
    public Signup_return signup(@PathVariable("email") String email, @PathVariable("passwd") String passwd)
    {
        return userService.addUser(email,passwd);
    }

    //4.1用户页面接口 & 5.2用户查询接口
    @RequestMapping(value = "/userInfo/{id}", method = RequestMethod.GET)
    public User user_Homepage(@PathVariable("id") int id)
    {
        return userService.queryUserById(id);
    }

    //4.2用户收藏文章界面接口
    @RequestMapping(value = "/userPaperInfo/{id}", method = RequestMethod.GET)
    public List<Paper> user_Paper_Cellection_Page(@PathVariable("id") int id)
    {
        return userService.queryUserPaperInfo(id);
    }

    //4.3用户关注用户界面接口
    @RequestMapping(value = "/userLinkInfo/{type}/{id}", method = RequestMethod.GET)
    public List<User> user_User_Cellection_Page(@PathVariable("id") int id, @PathVariable("type") int type)
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
    public void user_Collect_User(@PathVariable("type") boolean type, @PathVariable("id1") int id1, @PathVariable("id2") int id2)
    {
        userService.updateUserLink(id1,id2,type);
    }

    //5.1搜索用户功能接口
    @RequestMapping(value = "userSearch/{searchString}", method = RequestMethod.GET)
    public List<User> user_Search_User(@PathVariable("searchString") String searchString)
    {
        return userService.queryUserBySearch(searchString);
    }


}
