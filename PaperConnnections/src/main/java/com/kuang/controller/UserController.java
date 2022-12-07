package com.kuang.controller;

import com.kuang.pojo.Graph;
import com.kuang.pojo.Paper;
import com.kuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    //生成文档图谱界面接口
    @RequestMapping(value = "/buildGraph/{type}/{id}", method = RequestMethod.GET)
    public String buildGraph(@PathVariable("type") int type, @PathVariable("id") int id){

        return null;
    }

    @RequestMapping(value = "userPaper/{userId}/{paperId}/{flag}", method = RequestMethod.GET)
    public List<Paper> userPaper(@PathVariable("userId") int userId, @PathVariable("paperId") int paperId, @PathVariable("flag") int flag){

        return null;
    }


}
