package com.paper.connection.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//整个图的信息
public class Graph {
    //节点信息
    List<Node> node;

    //边信息
    List<Edge> edge;
}
