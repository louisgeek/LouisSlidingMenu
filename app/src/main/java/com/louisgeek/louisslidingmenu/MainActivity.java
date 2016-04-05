package com.louisgeek.louisslidingmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mDatas = Arrays
            .asList("菜单1", "菜单2", "菜单3", "菜单4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View menu_layout=LayoutInflater.from(this).inflate(R.layout.menu_layout, null);
        ListView listView= (ListView) menu_layout.findViewById(R.id.id_lv);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,mDatas);
        listView.setAdapter(arrayAdapter);

        // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        //设置侧滑菜单的位置，可选值LEFT , RIGHT , LEFT_RIGHT （两边都有菜单时设置）
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //根据dimension资源文件来设置阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //根据资源文件来设置滑动菜单的阴影效果
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置宽度
        //menu.setBehindWidth(50);//50px
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //设置SlidingMenu与下方视图的移动的速度比，当为1时同时移动，取值0-1
        menu.setBehindScrollScale(1.0f);

        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        //menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //为侧滑菜单设置布局  布局文件或View
      //  menu.setMenu(R.layout.menu_layout);
        menu.setMenu(menu_layout);

        menu.setSecondaryMenu(R.layout.right_menu_layout);
        //menu.setSecondaryShadowDrawable(R.drawable.shadow);
    }



}
