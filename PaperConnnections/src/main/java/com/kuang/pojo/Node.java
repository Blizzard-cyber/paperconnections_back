package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//创建节点数据
public class Node {
    //节点名称,建议格式为<作者名，年份>
    private String name;

    //结点的编号，可使用对应paper的编号
    private int id;

    //节点大小，可根据要求设置结点大小差别
    private int symbolSize;

    //节点颜色，建议根据年份不同设置渐变色，年份越近的颜色越深，越远的则越浅
    private String color;

    //前端绘图工具信息
    private ToolTip toolTip;
}
