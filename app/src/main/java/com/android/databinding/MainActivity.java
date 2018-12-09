package com.android.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.databinding.models.UserInfo;
import com.android.databinding.models.UserInfoObservable;
import com.android.databinding.models.UserInfoObservbleField;


public class MainActivity extends AppCompatActivity {

    enum Databinding{BASEOBSERVER,OBSERVABLE, OBSERVABLEFIELD}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Databinding databinding = Databinding.BASEOBSERVER;

        switch (databinding){
            case BASEOBSERVER:{
                setBaseObserverClass();
                break;
            }
            case OBSERVABLE:{
                setObservableClass();
                break;
            }
            case OBSERVABLEFIELD:{
                setObservableFieldClass();
                break;
            }
        }
    }


    private void setBaseObserverClass() {
        UserActivity dataBindingActivity = DataBindingUtil.
                setContentView(this,R.layout.activity_main);
        UserInfo userInfo =
                new UserInfo("Hello","baseObserver",
                        "https://www.gstatic.com/webp/gallery3/1.png");

        dataBindingActivity.setUserInfo(userInfo);

    }
    private void setObservableFieldClass() {
        DataObserverBinding dataObserverBinding = DataBindingUtil.setContentView(this,R.layout.activity_main1);
        UserInfoObservbleField userInfoObservbleField = new UserInfoObservbleField("Hello","Observer");
        dataObserverBinding.setUserInfoobserver(userInfoObservbleField);

    }
    private void setObservableClass() {
        DataObservableBinding dataObservableBinding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        UserInfoObservable userInfoObservable = new UserInfoObservable("Hello","Observable");
        dataObservableBinding.setUserInfoobserver(userInfoObservable);
    }
}
