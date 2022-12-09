package com.paper.connection.pojo;

import lombok.Data;

//不注册到spring
@Data
public class LoginReturn {
    private boolean logCheckFlag;
    private String logCheckDetail;
}
