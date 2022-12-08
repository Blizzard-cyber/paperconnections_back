package com.kuang.controller;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.Graph;
import com.kuang.pojo.Login_return;
import com.kuang.pojo.Paper;
import com.kuang.pojo.User;
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
    @Qualifier("paperServiceImpl")
    private PaperService paperService;


    //1.2用户收藏文章功能接口
    @RequestMapping(value = "/userPaper/{userId}/{paperId}/{flag}", method = RequestMethod.POST)
    public void user_Collect_Paper(@PathVariable("userId") int userId, @PathVariable("paperId") int paperId, @PathVariable("flag") boolean flag){

        userService.updateUserPaperLink(userId,paperId,flag);

    }

    //2.1登录接口 返回值两种类型存在Login_return实体类中
    @RequestMapping(value = "/singIn/{email}/{passwd}", method = RequestMethod.POST)
    public Login_return login(@PathVariable("email") String email, @PathVariable("passwd") String passwd) {
        Login_return login_return = new Login_return();
        int msg = userService.checkUserLog(email,passwd);

        if(msg == 0)
        {
            login_return.setLogCheckFlag(false);
            login_return.setLogCheckDetail("用户不存在，请注册");
        }
        if(msg == 1)
        {
            login_return.setLogCheckFlag(true);
            login_return.setLogCheckDetail("登录成功，欢迎");
        }
        if(msg == 2)
        {
            login_return.setLogCheckFlag(false);
            login_return.setLogCheckDetail("密码错误");
        }

        return null;
    }

    //2.2注册接口 返回值两种类型存在Signup_return实体类中
    @RequestMapping(value = "/singUp/{email}/{passwd}", method = RequestMethod.POST)
    public boolean signup(@PathVariable("email") String email, @PathVariable("passwd") String passwd)
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
        return paperService.queryPaperByRecommendation(id);
    }

    //4.3用户关注用户界面接口
    @RequestMapping(value = "/userLinkInfo/{type}/{id}", method = RequestMethod.GET)
    public List<User> user_User_Cellection_Page(@PathVariable("id") int id, @PathVariable("type") int type)
    {
        if(type == 0)
        {
            return userService.queryUserLinkTo(id);
        }
        if (type == 1)
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
