package com.agiliatech.android.showcasetest;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.config.PointerType;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;

    public Context getContext() {
        return context;
    }

    private ArrayList<MyImage> imageArrayList;
    public ImageView imageView;

    public ImageView getImageView() {
        return this.imageView;
    }

    public ViewPagerAdapter(Context context, ArrayList<MyImage> imageArrayList) {
        this.context = context;
        this.imageArrayList = imageArrayList;
    }

    @Override
    public int getCount() {
        return imageArrayList.size();
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //Inflate layout card item
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager_item, container, false);

        //Initiate imageview from layout
        ImageView image = view.findViewById(R.id.my_image);
        this.imageView = image;

        //Get image data
        MyImage resources = imageArrayList.get(position);
        int imgResource = resources.getImage();


        //Set image data
        image.setImageResource(imgResource);
        image.setTag(position);



        //Add view to container
        container.addView(view, position);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
