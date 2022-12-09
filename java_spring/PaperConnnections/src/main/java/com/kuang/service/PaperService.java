package com.kuang.service;

import com.kuang.pojo.Graph;
import com.kuang.pojo.Paper;
import com.kuang.pojo.User;

import java.util.List;

public interface PaperService {
    //按照id查询Paper
    public Paper queryPaperById(int id);

    //按照算法查询Paper，str为输入的特征字符串
    public List<Paper> queryPaperBySearch(String str);

    //查询与某个文章相关联的文章列表
    public List<Paper> queryPaperByConnection(int id);

    //根据给定id的文章推荐相关文章
    public List<Paper> queryPaperByRecommendation();

    //查询一个id生成的图
    public Graph queryPaperGraph(int id);

    public float getSimilarity(String x, String y);

}
