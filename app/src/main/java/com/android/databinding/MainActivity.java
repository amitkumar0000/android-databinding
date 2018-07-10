package com.android.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.databinding.models.UserInfo;
import com.android.databinding.models.UserInfoObservble;

public class MainActivity extends AppCompatActivity {

    enum Databinding{BASEOBSERVER, OBSERVABLEFIELD}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Databinding databinding = Databinding.OBSERVABLEFIELD;

        switch (databinding){
            case BASEOBSERVER:{
                setBaseObserverClass();
                break;
            }
            case OBSERVABLEFIELD:{
                setObservableFieldClass();
                break;
            }
        }
    }

    private void setObservableFieldClass() {
        DataObserverBinding dataObserverBinding = DataBindingUtil.setContentView(this,R.layout.activity_main1);
        UserInfoObservble userInfoObservble = new UserInfoObservble("Hello","Observer");
        dataObserverBinding.setUserInfoobserver(userInfoObservble);
    }

    private void setBaseObserverClass() {
        DataBindingActivity dataBindingActivity = DataBindingUtil.
                setContentView(this,R.layout.activity_main);
        UserInfo userInfo = new UserInfo("Hello","baseObserver");

        dataBindingActivity.setUserInfo(userInfo);
    }
}
