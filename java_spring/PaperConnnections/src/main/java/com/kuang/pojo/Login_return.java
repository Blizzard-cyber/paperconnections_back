package com.kuang.pojo;

import lombok.Data;

//不注册到spring
public class Login_return {
    private boolean logCheckFlag;
    private String logCheckDetail;

    public boolean isLogCheckFlag() {
        return logCheckFlag;
    }

    public void setLogCheckFlag(boolean logCheckFlag) {
        this.logCheckFlag = logCheckFlag;
    }

    public String getLogCheckDetail() {
        return logCheckDetail;
    }

    public void setLogCheckDetail(String logCheckDetail) {
        this.logCheckDetail = logCheckDetail;
    }
}
