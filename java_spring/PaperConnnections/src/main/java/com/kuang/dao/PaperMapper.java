package com.kuang.dao;

import com.kuang.pojo.Paper;

import java.util.List;

//主要负责paper
public interface PaperMapper {
    //按照id查询Paper
    Paper queryPaperById(int id);

    //按照算法查询Paper，str为输入的特征字符串
    List<Paper> queryPaperBySearch(String str);

    //查询与某个文章相关联的文章列表
    List<Paper> queryPaperByConnection(int id);

    //根据给定id的文章推荐相关文章
    List<Paper> queryPaperByRecommendation();
}
