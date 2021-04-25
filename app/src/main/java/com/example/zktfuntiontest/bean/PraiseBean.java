package com.example.zktfuntiontest.bean;

import cn.leancloud.AVObject;
import cn.leancloud.annotation.AVClassName;

@AVClassName("PraiseBean")
public class PraiseBean extends AVObject {
    public static final String PRAISEMAN = "praiseman";//点赞人
    public static final String DYNAMIC = "dynamic";//点赞动态

    public UserBean getPraiseman(){
        return  getAVObject(PRAISEMAN);
    }

    public void setPraiseman(UserBean praiseman) {
        put(PRAISEMAN,praiseman);
    }

    public DynamicBean getDynamic(){
        return  getAVObject(DYNAMIC);
    }

    public void setDynamic(DynamicBean dynamic) {
        put(DYNAMIC,dynamic);
    }
}
