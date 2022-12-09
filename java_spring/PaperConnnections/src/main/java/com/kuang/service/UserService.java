package com.kuang.service;

import com.kuang.pojo.Login_return;
import com.kuang.pojo.Paper;
import com.kuang.pojo.Signup_return;
import com.kuang.pojo.User;

import java.util.List;

public interface UserService {

    //按照id查询user
    User queryUserById(int id);

    //按照email查询user
    User queryUserByEmail(String email);

    //登录
    //0 表示用户不存在
    //1 表示登录成功
    //2 表示密码错误
    Login_return checkUserLog(String email, String pwd);

    //按照算法查询user，str为输入的特征字符串
    List<User> queryUserBySearch(String str);

    //按照算法查询user,查询指定id的user关注的用户List
    List<User> queryUserLinkTo(int id);

    //按照算法查询user,查询指定id的user被关注的用户List
    List<User> queryUserLinkFrom(int id);


    //查询用户关注关系
    //返回值 0 表示未关注，1表示关注
    int queryUserLink(int userId1,int userId2);

    //查询用户与文章收藏关系
    //返回值 0 表示未收藏，1表示收藏
    int queryUserPaperLink(int userId,int paperId);

    //添加一个用户
    Signup_return addUser(String email, String pwd);

    //修改用户信息
    int updateUser(User user);

    //将一个用户加入/取消关注
    //表示userId1用户关注/取消关注了userId2用户
    //返回值0/1表示更改后的状态 0 表示未关注，1表示关注
    int updateUserLink(int userId1,int userId2,boolean typ);

    //将一篇文章加入/取消收藏
    //表示userId用户收藏了paperId文章
    //返回值0/1表示更改后的状态 0 表示未收藏，1表示收藏
    boolean updateUserPaperLink(int userId,int paperId,boolean typ);
}
