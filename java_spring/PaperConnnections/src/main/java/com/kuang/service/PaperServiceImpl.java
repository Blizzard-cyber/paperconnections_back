package com.kuang.service;

import com.kuang.pojo.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService{
    @Override
    public Paper queryPaperById(int id) {
        return null;
    }

    @Override
    public List<Paper> queryPaperBySearch(String str) {
        return null;
    }

    @Override
    public List<Paper> queryPaperByConnection(int id) {
        return null;
    }

    @Override
    public List<Paper> queryPaperByRecommendation(int id) {
        return null;
    }

    @Override
    public List<Paper> queryPaperUserCollection(int id) {
        return null;
    }

}
