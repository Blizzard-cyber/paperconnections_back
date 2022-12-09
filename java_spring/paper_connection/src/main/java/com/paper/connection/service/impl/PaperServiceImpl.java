package com.paper.connection.service.impl;

import com.paper.connection.dao.PaperDao;
import com.paper.connection.pojo.Edge;
import com.paper.connection.pojo.Graph;
import com.paper.connection.pojo.Paper;
import com.paper.connection.pojo.Node;
import com.paper.connection.service.PaperService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.min;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;

    private final float threshold = (float)0.2;
    private final int Num = 20;
    public void setPaperMapper(PaperDao paperDao) {
        this.paperDao = paperDao;
    }

    @Override
    public Paper queryPaperById(int id) {
        return paperDao.queryPaperById(id);
    }

    @Override
    public List<Paper> queryPaperBySearch(String str)
    {
        return paperDao.queryPaperBySearch(str);
    }
//    public List<Paper> queryPaperBySearch(String str) {
//        List<Paper>  list = paperDao.allPaper();
//        List<Pair<Paper, Float>> pairs = new ArrayList<>();
//
//        for(int i = 0; i < list.size(); i++){
//            float tmp = getSimilarity(list.get(i).getTitle(), str);
//            if(tmp > threshold){
//                pairs.add(Pair.of(list.get(i), tmp));
//            }
//        }
//
//        //排序, 距离小的在前面，按照距离升序排列
//        pairs.sort(new Comparator<Pair<Paper, Float>>() {
//            @Override
//            public int compare(Pair<Paper, Float> o1, Pair<Paper, Float> o2) {
//                float tmp = o1.getValue() - o2.getValue();
//                if (tmp > 0) return 1;
//                else if (tmp == 0) return 0;
//                else return -1;
//            }
//        });
//
//        //取出前Num个Paper返回
//        list.clear();
//        for(int i = 0; i<= min(pairs.size(), Num);i++){
//            list.add(pairs.get(i).getKey());
//        }
//        return list;
//    }

    @Override
    public List<Paper> queryPaperByConnection(int id) {
        Paper paper = paperDao.queryPaperById(id);
        List<Paper>  list = paperDao.allPaper();
        List<Pair<Paper, Float>> pairs = new ArrayList<>();
        pairs.add(Pair.of(paper, 1.0F));

        for(int i = 0; i < list.size(); i++){
            if(i==paper.getPaperId())continue;
            float tmp = getSimilarity(list.get(i).getTitle(), paper.getTitle());
            if(tmp > threshold){
                pairs.add(Pair.of(list.get(i), tmp));
            }
        }

        //排序, 距离小的在前面，按照距离升序排列
        pairs.sort(new Comparator<Pair<Paper, Float>>() {
            @Override
            public int compare(Pair<Paper, Float> o1, Pair<Paper, Float> o2) {
                float tmp = o1.getValue() - o2.getValue();
                if (tmp > 0) return 1;
                else if (tmp == 0) return 0;
                else return -1;
            }
        });

        //取出前Num个Paper返回
        list.clear();
        for(int i = 0; i<= min(pairs.size(), Num);i++){
            list.add(pairs.get(i).getKey());
        }
        return list;
    }

    @Override
    public List<Paper> queryPaperByRecommendation() {
        //暂时使用随机推荐的方法
        List<Paper> list = paperDao.allPaper();
        Collections.shuffle(list);
        return list.subList(0,9);
    }

    @Override
    public Graph queryPaperGraph(int id) {
        List<Paper> list = queryPaperByConnection(id);
        List<Node> node = new ArrayList<>();
        List<Edge> edge = new ArrayList<>();

        //加入点
        for (Paper paper : list) node.add(new Node(paper));

        //加入边
        //加入边的逻辑是如果两个paper的联系大于了threshold
        for(int i=0;i<list.size();i++)
            for(int j=i+1;j<list.size();j++){
                if(getSimilarity(list.get(i).getTitle(), list.get(j).getTitle()) > min(0.9, threshold*2))
                    edge.add(new Edge(list.get(i).getPaperId(), list.get(j).getPaperId()));
            }

        //返回整个图
        return new Graph(node, edge);
    }

    @Override
    public float getSimilarity(String x, String y) {
        int len = min(x.length(), y.length());
        if(len == 0) return -1;
        return 1.0F * (len - StringUtils.getLevenshteinDistance(x,y)) / len;
    }


}
