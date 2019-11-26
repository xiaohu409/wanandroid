package com.github.xiaohu409.wanandroid.mvc.controller;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseActivity;
import com.github.xiaohu409.wanandroid.mvc.widget.CircleTabHost;

/**
 * 项目名称：
 * 文件名称：MainActivity.java
 * 文件描述：主界面
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public class MainActivity extends BaseActivity implements CircleTabHost.OnTabListener {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        //导航标题
        String[] tabTitle = getResources().getStringArray(R.array.tab_title);
        //导航图标
        int[] tabIco = {R.drawable.foot1_sel, R.drawable.foot2_sel, R.drawable.foot3_sel, R.drawable.foot4_sel};
        //导航的fragment
        Class<?>[] tabFragment = {BlankFragment1.class, BlankFragment2.class,
                BlankFragment3.class, BlankFragment4.class};
        //实例化TabHost
        CircleTabHost circleTabHost = findViewById(R.id.circle_tab_id);
        for (int i = 0; i < tabTitle.length; i++) {
            //实例化Tab
            CircleTabHost.TabParam tabParam = new CircleTabHost.TabParam(tabIco[i], tabTitle[i], tabFragment[i]);
            //添加Tab
            circleTabHost.addTab(tabParam);
        }
        //配置FragmentManager和Content id
        circleTabHost.setup(getSupportFragmentManager(), R.id.content_id);
        circleTabHost.setOnTabListener(this);
    }

    @Override
    public void onTabChange(int index, CircleTabHost.TabParam param) {

    }
}
