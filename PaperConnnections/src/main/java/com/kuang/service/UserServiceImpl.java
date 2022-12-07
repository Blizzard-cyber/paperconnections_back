package com.kuang.service;

import com.kuang.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User queryUserById(int id) {
        return null;
    }

    @Override
    public User queryUserByEmail(String email) {
        return null;
    }

    @Override
    public int checkUserLog(String email, String pwd) {
        return 0;
    }

    @Override
    public List<User> queryUserBySearch(String str) {
        return null;
    }

    @Override
    public List<User> queryUserLinkTo(int id) {
        return null;
    }

    @Override
    public List<User> queryUserLinkFrom(int id) {
        return null;
    }

    @Override
    public int queryUserLink(int userId1, int userId2) {
        return 0;
    }

    @Override
    public int queryUserPaperLink(int userId, int paperId) {
        return 0;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int updateUserLink(int userId1, int userId2, int typ) {
        return 0;
    }

    @Override
    public int updateUserPaperLink(int userId, int paperId, int typ) {
        return 0;
    }
}
