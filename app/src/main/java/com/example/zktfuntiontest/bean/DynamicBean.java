package com.example.zktfuntiontest.bean;

import java.util.List;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.annotation.AVClassName;

@AVClassName("DynamicBean")
public class DynamicBean extends AVObject {

    public static final String CONTENT = "content";
    public static final String AUTHOR = "author";

    public static final String POSTDATE = "postdate";//发表时间
    public static final String IMAGES = "Images";//图片集合


    public String getContent() {
        return getString(CONTENT);
    }

    public void setContent(String content) {
        put(CONTENT,content);
    }

    public String getPostdate() {
        return getString(POSTDATE);
    }

    public void setPostdate(String postdate) {
        put(POSTDATE,postdate);
    }

    public UserBean getAuthor(){
        return  getAVObject(AUTHOR);
    }

    public void setAuthor(UserBean author) {
        put(AUTHOR,author);
    }


    public List<AVFile> getImages() {
        return getList(IMAGES);
    }

    public void setImages(List<AVFile> images) {
        put(IMAGES,images);
    }

}
