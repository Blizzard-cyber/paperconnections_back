package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//主要负责user
public interface UserMapper {
    //检查用户名存在
    int checkEmail(String name);

    //检查用户名和密码
    int checkLogin(@Param("name") String name, @Param("pwd") String pwd);

    //返回所有user
    List<User> allUser();
    //done

    //按照id查询user
    User queryUserById(int id);
    //done

    //按照email查询user
    User queryUserByEmail(String email);
    //done

    //按照算法查询user，str为输入的特征字符串
    List<User> queryUserBySearch(String str);
    //done

    //按照算法查询user,查询指定id的user关注的用户List
    List<User> queryUserLinkTo(int id);
    //done

    //按照算法查询user,查询指定id的user被关注的用户List
    List<User> queryUserLinkFrom(int id);
    //done

    //查询用户关注关系
    //返回值 0 表示未关注，1表示关注
    int queryUserLink(@Param("userId1") int userId1,@Param("userId2") int userId2);
    //done

    //查询用户与文章收藏关系
    //返回值 0 表示未收藏，1表示收藏
    int queryUserPaperLink(@Param("userId") int userId, @Param("paperId") int paperId);
    //done

    //添加一个用户
    int addUser(User user);
    //done

    //修改用户信息
    int updateUser(User user);
    //done

    //userId1关注userId2
    int insertUserUserlink(@Param("userId1") int userId1,@Param("userId2") int userId2);
    //done

    //userId1取消关注userId2
    int deleteUserUserLink(@Param("userId1") int userId1,@Param("userId2") int userId2);
    //done

    //将一个用户加入/取消关注
    //表示userId1用户关注/取消关注了userId2用户
    //返回值0/1表示更改后的状态 0 表示未关注，1表示关注
    //int updateUserLink(int userId1,int userId2,int typ);

    int insertUserPaperLink(@Param("userId") int userId,@Param("paperId") int paperId);
    //done

    int deleteUserPaperLink(@Param("userId") int userId,@Param("paperId") int paperId);
    //done

    //将一篇文章加入/取消收藏
    //表示userId用户收藏了paperId文章
    //返回值0/1表示更改后的状态 0 表示未收藏，1表示收藏
    //int updateUserPaperLink(int userId,int paperId,int typ);
}
