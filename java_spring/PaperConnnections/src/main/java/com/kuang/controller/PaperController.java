package com.kuang.controller;

import com.kuang.pojo.Paper;
import com.kuang.service.PaperService;
import com.kuang.service.PaperServiceImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {
    @Autowired
    @Qualifier("paperServiceImpl")
    private PaperService paperService;

    //1.1生成文档图谱界面接口
    @RequestMapping(value = "/buildGraph/{type}/{id}", method = RequestMethod.GET)
    public Object buildGraph(@PathVariable("type") int type, @PathVariable("id") int id){

        return null;
    }

    //3.1推荐界面接口
    @RequestMapping(value = "/recommendInfo/{id}/{flagLog}", method = RequestMethod.GET)
    public List<Paper> user_Recommend_Page(@PathVariable("id") int id, @PathVariable("flagLog") boolean flagLog)
    {
        return null;
    }


}
