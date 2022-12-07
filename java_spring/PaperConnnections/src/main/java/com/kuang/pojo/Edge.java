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
    private String source;

    //边的目标节点名称的字符串【因为是无向边，所以只需要1-2即可，不再需要2-1】
    private String target;

    //前端绘图工具信息
    private ToolTip toolTip;
}
