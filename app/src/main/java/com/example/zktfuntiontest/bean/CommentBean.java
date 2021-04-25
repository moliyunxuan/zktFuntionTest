package com.example.zktfuntiontest.bean;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.annotation.AVClassName;

@AVClassName("CommentBean")
public class CommentBean extends AVObject {


    public static final String CONTENT = "content";
    public static final String SENDER = "sender";
    public static final String DYNAMIC = "dynamic";
    public static final String TYPE = "type";//1代表正常评论，2代表回复评论
    public static final String POSITION = "position";
    public static final String COMMENTPOSITION = "commentposition";
    public static final String REPLAY = "reply";//回复谁的评论

    public String getContent() {
        return getString(CONTENT);
    }

    public void setContent(String content) {
        put(CONTENT,content);
    }

    public UserBean getSender(){
        return  getAVObject(SENDER);
    }

    public void setSender(UserBean sender) {
        put(SENDER,sender);
    }

    public DynamicBean getDynamic(){
        return  getAVObject(DYNAMIC);
    }

    public void setDynamic(DynamicBean dynamic) {
        put(DYNAMIC,dynamic);
    }

    public int getCommentPosition() {
        return getInt(COMMENTPOSITION);
    }

    public void setCommentPosition(int commentPosition) {
        put(COMMENTPOSITION,commentPosition);
    }

    public int getPosition() {
        return getInt(POSITION);
    }

    public void setPosition(int position) {
        put(POSITION,position);
    }

    public int getType() {
        return getInt(TYPE);
    }

    public void setType(int type) {
        put(TYPE,type);
    }

    public UserBean getReply() {
        return getAVObject(REPLAY);
    }

    public void setReply(UserBean reply) {
        put(REPLAY,reply);
    }








}
