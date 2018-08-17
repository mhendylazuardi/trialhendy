package com.example.xback.ini;

import android.widget.ImageView;

public class ImageLoader {
    public static void loadImage(String URL, ImageView imageView){
        GlideApp.with(imageView.getContext())
                .load(URL)
                .error(android.R.color.darker_gray)
                .placeholder(android.R.color.darker_gray)
                .into(imageView);
    }
}
