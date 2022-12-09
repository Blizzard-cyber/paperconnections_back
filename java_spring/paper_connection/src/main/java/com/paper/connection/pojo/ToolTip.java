package com.paper.connection.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//前端绘图工具信息
public class ToolTip {
    //鼠标hover是否显示tooltip【加上就行，让他全为true】
    private boolean show;

    //提示框显示内容，内容为paper的title
    private String formatter;
}
