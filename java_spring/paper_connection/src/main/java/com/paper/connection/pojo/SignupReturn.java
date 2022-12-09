package com.paper.connection.pojo;

import lombok.Data;

//不注册到spring
@Data
public class SignupReturn {
    private boolean signCheckFlag;
    private String signCheckDetail;
}
