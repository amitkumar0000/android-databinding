package com.android.databinding.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

public class UserInfo extends BaseObservable{
    String firstName;
    String lastName;

    public UserInfo(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    int toggle = 1;
    public void onClick(View view){
        if(toggle == 1) {
            setFirstName("NOT-NULL");
            setLastName("NOT-NULL");
            toggle = 0;
        }else{
            setFirstName("NULL");
            setLastName("NULL");
            toggle = 1;
        }
    }
}
