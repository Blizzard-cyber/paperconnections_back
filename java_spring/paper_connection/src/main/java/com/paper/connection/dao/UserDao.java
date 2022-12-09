package com.paper.connection.dao;

import com.paper.connection.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//主要负责user
public interface UserDao {
    //检查用户名存在
    int checkEmail(String name);

    //检查用户名和密码
    int checkLogin(@Param("name") String name, @Param("pwd") String pwd);

    //返回所有user
    List<User> allUser();
    //done

    //按照id查询user
    User queryUserById(@Param("id") int id);
    //done

    //按照email查询user
    User queryUserByEmail(@Param("email") String email);
    //done

    //按照算法查询user，str为输入的特征字符串
    List<User> queryUserBySearch(@Param("str") String str);
    //done

    //按照算法查询user,查询指定id的user关注的用户List
    List<User> queryUserLinkTo(@Param("id") int id);
    //done

    //按照算法查询user,查询指定id的user被关注的用户List
    List<User> queryUserLinkFrom(@Param("id") int id);
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

    int insertUserPaperLink(@Param("userId") int userId,@Param("paperId") int paperId);
    //done

    int deleteUserPaperLink(@Param("userId") int userId,@Param("paperId") int paperId);
    //done

}
