package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//关系数据
public class Edge {
    //边的源节点名称的字符串
    private int source;

    //边的目标节点名称的字符串【因为是无向边，所以只需要1-2即可，不再需要2-1】
    private int target;

    //前端绘图工具信息
    private ToolTip toolTip;

    public Edge(int from, int to){
        this.source = from;
        this.target = to;
        this.toolTip = new ToolTip(false,"");
    }
}
