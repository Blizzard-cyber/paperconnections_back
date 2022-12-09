package com.paper.connection.dao;

import com.paper.connection.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//主要负责paper
public interface PaperDao {
    //返回所有Paper
    List<Paper> allPaper();
    //done

    //按照id查询Paper
    Paper queryPaperById(@Param("id") int id);
    //done

    //按照算法查询Paper，str为输入的特征字符串
    List<Paper> queryPaperBySearch(@Param("str") String str);
    //done
}
