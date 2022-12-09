package com.paper.connection.controller;

import com.paper.connection.pojo.Paper;
import com.paper.connection.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    //1.1生成文档图谱界面接口
    @RequestMapping(value = "/buildGraph/{type}/{id}", method = RequestMethod.GET)
    public Object buildGraph(@PathVariable("type") int type, @PathVariable("id") int id){
        if(type==0){
            //type = 0, 返回前9个paper
            return paperService.queryPaperByConnection(id).subList(0,9);
        }else if (type==1){
            //type = 1, 返回一个graph信息
            return paperService.queryPaperGraph(id);
        }else {
            //type = 1, 直接返回一个paper
            return paperService.queryPaperById(id);
        }
    }

    //3.1推荐界面接口
    @RequestMapping(value = "/recommendInfo/{id}/{flagLog}", method = RequestMethod.GET)
    public List<Paper> userRecommendPage(@PathVariable("id") int id, @PathVariable("flagLog") boolean flagLog)
    {
        return paperService.queryPaperByRecommendation();
    }
}
