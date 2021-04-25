package com.example.zktfuntiontest.bean;
import android.os.Parcelable;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.AVParcelableObject;
import cn.leancloud.annotation.AVClassName;

@AVClassName("UserBean")
public class UserBean extends AVObject {
    public static final Parcelable.Creator CREATOR = AVParcelableObject.AVObjectCreator.instance;

    public static final String NAME = "name";    //用户名
    public static final String AVATAR = "avatar";//头像

    public UserBean(){

    }
    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public AVFile getAvatar(){
        return  getAVFile(AVATAR);
    }

    public void setAvatar(AVFile avatar)
    {
        put(AVATAR,avatar);
    }

}
