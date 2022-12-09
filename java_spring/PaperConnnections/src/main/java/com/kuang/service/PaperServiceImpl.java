package com.kuang.service;

import com.kuang.dao.PaperMapper;
import com.kuang.pojo.Edge;
import com.kuang.pojo.Graph;
import com.kuang.pojo.Node;
import com.kuang.pojo.Paper;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.*;

import static java.lang.Math.min;

@Service
public class PaperServiceImpl implements PaperService{
    @Autowired
    PaperMapper paperMapper;

    private final float threshold = (float)0.2;
    private final int Num = 20;
    public void setPaperMapper(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }

    @Override
    public Paper queryPaperById(int id) {
        return paperMapper.queryPaperById(id);
    }

    @Override
    public List<Paper> queryPaperBySearch(String str) {
        List<Paper>  list = paperMapper.allPaper();
        List<Pair<Paper, Float>> pairs = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            float tmp = getSimilarity(list.get(i).getTitle(), str);
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
    public List<Paper> queryPaperByConnection(int id) {
        Paper paper = paperMapper.queryPaperById(id);
        List<Paper>  list = paperMapper.allPaper();
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
        List<Paper> list = paperMapper.allPaper();
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
