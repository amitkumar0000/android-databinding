package com.android.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.databinding.models.UserInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBindingActivity dataBindingActivity = DataBindingUtil.
                setContentView(this,R.layout.activity_main);
        UserInfo userInfo = new UserInfo("Hello","world");

        dataBindingActivity.setUserInfo(userInfo);

    }
}
