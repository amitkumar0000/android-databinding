package com.android.databinding.models;


import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.android.databinding.library.baseAdapters.BR;

public class UserInfoObservable implements Observable {

    String firstName;
    String lastName;

    PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public UserInfoObservable(String fname, String lname){
        this.firstName = fname;
        this.lastName = lname;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        registry.notifyChange(this, BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        registry.notifyChange(this, BR.lastName);

    }

    int toggle = 0;
    public void onClick(){
        if(toggle == 0) {
            setFirstName("First");
            setLastName("last");
            toggle = 1;
        }else{
            setFirstName("last");
            setLastName("first");
            toggle = 0;
        }
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.remove(callback);
    }
}
