package com.example.zktfuntiontest.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CommunityService {

    /**
     * 创建一个用户
     * @param name
     * @return user
     */
    public  AVObject createUser(String name) {
        AVFile file = new AVFile(
                "logo.png",
                "https://leancloud.cn/assets/imgs/press/Logo%20-%20Blue%20Padding.a60eb2fa.png",
                new HashMap<String, Object>()
        );
        AVObject user = new AVObject("UserBean");
        user.put("name",name);
        user.put("avatar",file);
        user.saveInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(AVObject avObject) {
                Log.d("msg","用户保存成功");
            }
            @Override
            public void onError(Throwable e) {
                Log.d("msg","用户保存失败,: "+e);
            }
            @Override
            public void onComplete() {
            }
        });
        return user;
    }

    /**
     * 创建一个动态
     * @param author
     * @param content
     * @param postdate
     * @return dynamic
     */
    public  AVObject createDynamic(AVObject author,String content,String postdate) {

        AVObject dynamic = new AVObject("DynamicBean");
        dynamic.put("author",author);
        dynamic.put("content",content);
        dynamic.put("postdate",postdate);
        dynamic.saveInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(AVObject avObject) {
                Log.d("msg","动态保存成功");
            }
            @Override
            public void onError(Throwable e) {
                Log.d("msg","用户保存失败,: "+e);
            }
            @Override
            public void onComplete() {
            }
        });
        return dynamic;

    }
    /**
     * 点赞
     * @param praiseMan 点赞人
     * @param  dynamic 动态
     * @return
     */
    public void PraiseItem(AVObject praiseMan,AVObject dynamic) {


        AVObject praise = new AVObject("PraiseBean");
        praise.put("praiseman",praiseMan);
        praise.put("dynamic",dynamic);

        praise.saveInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(AVObject avObject) {
                Log.d("msg","点赞成功");
            }
            @Override
            public void onError(Throwable e) {
                Log.d("msg","点赞失败,: "+e);
            }
            @Override
            public void onComplete() {
            }
        });
    }

    /**
     * 展示点赞列表
     * @param dynamic 动态
     * @return praiseMans 点赞人集合
     */
    public  String showPraise(AVObject dynamic) {

        List<AVObject> praiseMans = new ArrayList<>();

        AVQuery<AVObject> query = new AVQuery<>("PraiseBean");
        query.whereEqualTo("dynamic", dynamic);
        query.include("praiseman");
        query.findInBackground().subscribe(new Observer<List<AVObject>>() {
            public void onSubscribe(Disposable disposable) {}
            public void onNext(List<AVObject> praises) {
                //与dynamic相关联的PraiseBean

                int i=0;
                for(AVObject praise:praises) {
                    AVObject praiseMan = praise.getAVObject("praiseman");

                    praiseMans.add(praiseMan);
                    //Log.d("msg","点赞人 "+praiseMan.getString("name"));



                }
                Log.d("msg","点赞集合查找成功");
              //  Log.d("msg1","程序在后台线程");


            }
            public void onError(Throwable throwable) {
                Log.d( "msg","点赞集合查找失败"+throwable);



            }
            public void onComplete() {
               for(int i=0;i<praiseMans.size();i++) {
                    Log.d("msg","点赞人 "+praiseMans.get(i).getString("name"));
                }

            }
        });

        return "111";
    }


}
