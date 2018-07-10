package com.android.databinding.models;


import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class UserInfoObservbleField {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    ObservableInt count;

    public UserInfoObservbleField(String fname, String lname){
        firstName.set(fname);
        lastName.set(lname);
    }

    int toggle = 0;
    public void onClick(){
        if(toggle == 0) {
            firstName.set("First");
            lastName.set("last");
            toggle = 1;
        }else{
            firstName.set("last");
            lastName.set("first");
            toggle = 0;
        }
    }
}
