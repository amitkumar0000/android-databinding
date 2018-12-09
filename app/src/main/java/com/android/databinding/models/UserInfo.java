package com.android.databinding.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;

public class UserInfo extends BaseObservable{
    String firstName;
    String lastName;
    String imageUrl;
    String errorUrl;

    public UserInfo(String firstName,String lastName,String errorUrl,String imageUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.errorUrl = errorUrl;
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

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);

    }

    @Bindable
    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
        notifyPropertyChanged(BR.errorUrl);
    }

    @BindingAdapter(value = {"imageUrl", "errorUrl"}, requireAll = true)
    public static void loagImage(ImageView imageView, String imagUrl, String errorUrl) {
        Log.d("TAG"," imageUrl:- "+ imagUrl+"  errorUrl:- "+ errorUrl);
        if(imagUrl.length()>0) {
            Glide.with(imageView.getContext()).load(imagUrl).into(imageView);
        }
        else if(errorUrl.length() >0){
            Glide.with(imageView.getContext()).load(errorUrl).into(imageView);

        }

    }

    int toggle = 1;
    public void onClick(View view){
        if(toggle == 1) {
            setFirstName("firstName");
            setLastName("secondName");
            setImageUrl("https://www.gstatic.com/webp/gallery3/1.png");
            toggle = 0;
        }else{
            setFirstName("secondName");
            setLastName("firstName");
            setImageUrl("https://www.gstatic.com/webp/gallery/1.jpg");
            toggle = 1;
        }
    }
}
