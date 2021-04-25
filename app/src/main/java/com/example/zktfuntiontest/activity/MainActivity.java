package com.example.zktfuntiontest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.zktfuntiontest.R;
import com.example.zktfuntiontest.bean.UserBean;
import com.example.zktfuntiontest.service.CommunityService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVRelation;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private CommunityService communityService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 提供 this、App ID、App Key、Server Host 作为参数
        // 注意这里千万不要调用 cn.leancloud.core.AVOSCloud 的 initialize 方法，否则会出现 NetworkOnMainThread 等错误。
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        AVOSCloud.initialize(this, "B81m6boguWT8FFxuuwPSrFFF-gzGzoHsz", "FmS4f0h37zTdkML3VdGy8Mo7", "https://b81m6bog.lc-cn-n1-shared.com");
        setContentView(R.layout.activity_main);
        communityService = new CommunityService();
        //创建用户
//        AVObject user1 = communityService.createUser("谢小凤");
//        AVObject user2 = communityService.createUser("刘威");
        AVObject user1 = AVObject.createWithoutData("UserBean","6084544647454649c5606357");
        AVObject user2 = AVObject.createWithoutData("UserBean","6084544647454649c5606358");
        //创建动态
        // AVObject dynamic = communityService.createDynamic(user2,"沙发！","刚刚");
        AVObject dynamic = AVObject.createWithoutData("DynamicBean","6085585a469d556178090632");
        //点赞
        //communityService.PraiseItem(user1,dynamic);
        //communityService.PraiseItem(user2,dynamic);

       //communityService.showPraise(dynamic);
        Log.d("msg1",communityService.showPraise(dynamic));


           // Log.d("msg2","程序在主线程");
           // Log.d("msg","点赞人 "+praiseMans.get(0).getString("name"));

            //Log.d("msg","点赞人 "+praiseMans.get(1).getString("name"));











        
    }
}