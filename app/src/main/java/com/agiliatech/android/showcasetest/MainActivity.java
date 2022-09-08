package com.agiliatech.android.showcasetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.config.PointerType;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button startShowcase;
    private ImageView imageView;
    private ViewPager viewPager;
    private ArrayList<MyImage> imageArrayList;
    private ViewPagerAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewPager);
        button1 = findViewById(R.id.button1);
        //Load Cards
        loadCards();

        startShowcase = findViewById(R.id.start_showcase);

        startShowcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startShowCase();
            }
        });

        button2 = findViewById(R.id.button2);


    }

    public void startShowCase(){
        new GuideView.Builder(MainActivity.this)
                .setTitle("Button Showcase text")
                .setContentText("Guide Description Showcase Text \n Guide Description Text \n Guide Description text")
                .setTargetView(button1)
                .setDismissType(DismissType.anywhere)
                .setPointerType(PointerType.none)
                .setContentTypeFace(Typeface.DEFAULT_BOLD)
                .setTitleTypeFace(Typeface.MONOSPACE)
                .setGravity(Gravity.center)
                .setIndicatorHeight(10)
                .setTitleTextSize(18)
                .setContentTextSize(15)
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        new GuideView.Builder(MainActivity.this)
                                .setTitle("Item Showcase Text")
                                .setContentText("Guide Description Showcase Text \n Guide Description Text \n Guide Description text")
                                .setTargetView(findViewById(R.id.view_pager_item))
                                .setIndicatorHeight(10)
                                .setDismissType(DismissType.anywhere)
                                .setPointerType(PointerType.none)
                                .setContentTypeFace(Typeface.DEFAULT_BOLD)
                                .setTitleTypeFace(Typeface.MONOSPACE)
                                .setGravity(Gravity.center)
                                .setTitleTextSize(18)
                                .setContentTextSize(15)

                                .build()
                                .show();

                    }
                })
                .build()
                .show();
    }

    public List<MyImage> getArrayList(){
        imageArrayList = new ArrayList<>();

        //Add items to list
        imageArrayList.add(new MyImage(R.drawable.image1));
        imageArrayList.add(new MyImage(R.drawable.image2));
        imageArrayList.add(new MyImage(R.drawable.image3));
        imageArrayList.add(new MyImage(R.drawable.image4));
        imageArrayList.add(new MyImage(R.drawable.image5));

        return imageArrayList;
    }


    private void loadCards() {

        imageArrayList = new ArrayList<>();

        //Add items to list
        imageArrayList.add(new MyImage(R.drawable.image1));
        imageArrayList.add(new MyImage(R.drawable.image2));
        imageArrayList.add(new MyImage(R.drawable.image3));
        imageArrayList.add(new MyImage(R.drawable.image4));
        imageArrayList.add(new MyImage(R.drawable.image5));

        //Setup adapter
        myAdapter = new ViewPagerAdapter(this, imageArrayList);

        //Set adapter to viewPager
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(150,0,300,0);

    }

}