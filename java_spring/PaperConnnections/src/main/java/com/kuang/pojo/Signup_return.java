package com.kuang.pojo;

//不注册到spring
public class Signup_return {
    private boolean signCheckFlag;
    private String signCheckDetail;

    public boolean isSignCheckFlag() {
        return signCheckFlag;
    }

    public void setSignCheckFlag(boolean signCheckFlag) {
        this.signCheckFlag = signCheckFlag;
    }

    public String getSignCheckDetail() {
        return signCheckDetail;
    }

    public void setSignCheckDetail(String signCheckDetail) {
        this.signCheckDetail = signCheckDetail;
    }
}
