package com.android.databinding.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;

public class UserInfo extends BaseObservable {
    String firstName;
    String lastName;
    String imageUrl;

    public UserInfo(String firstName, String lastName, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;

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

    @BindingAdapter(value = {"imageUrl"}, requireAll = true)
    public static void loagImage(ImageView imageView, String imagUrl) {
        Log.d("TAG", " imageUrl:- " + imagUrl + "  errorUrl:- ");

        Glide.with(imageView.getContext()).load(imagUrl).into(imageView);


    }

    int toggle = 1;

    public void onClick(View view) {
        if (toggle == 1) {
            setFirstName("firstName");
            setLastName("secondName");
            setImageUrl("https://www.gstatic.com/webp/gallery3/1.png");
            toggle = 0;
        } else {
            setFirstName("secondName");
            setLastName("firstName");
            setImageUrl("https://www.gstatic.com/webp/gallery/1.jpg");
            toggle = 1;
        }
    }
}
