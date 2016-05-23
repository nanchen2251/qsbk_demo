package com.example.nanchen.qsbk_demo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GuideActivity extends Activity implements View.OnClickListener,ViewPager.OnPageChangeListener {


    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    private static final String KEY_GUIDE_ACTIVITY = "isFirstIn";
    private static SharedPreferences sp;
    // 定义ViewPager对象
    private ViewPager viewPager;
    // 定义ViewPager适配器
    private ViewPagerAdapter vpAdapter;
    // 定义一个ArrayList来存放View
    private ArrayList<View> views;
    // 引导图片资源
//    private static final int[] pics = { R.mipmap.guide_1, R.mipmap.guide_2,
//            R.mipmap.guide_3, R.mipmap.guide_4 };
    // 底部小点的图片
    private ImageView[] points;
    // 记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        // 实例化ArrayList对象
        views = new ArrayList<View>();
        // 实例化ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        // 实例化ViewPager适配器
        vpAdapter = new ViewPagerAdapter(views);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 定义一个布局并设置参数
//        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);

        // 初始化引导图片列表
//        for (int i = 0; i < pics.length; i++) {
//            ImageView iv = new ImageView(this);
//            iv.setLayoutParams(mParams);
//            //防止图片不能填满屏幕
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
//            //加载图片资源
//            iv.setImageResource(pics[i]);
//            views.add(iv);
//        }

        views.add(getLayoutInflater().inflate(R.layout.pager_1,null));
        views.add(getLayoutInflater().inflate(R.layout.pager_2, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_3,null));
        views.add(getLayoutInflater().inflate(R.layout.pager_4,null));
        // 设置数据
        viewPager.setAdapter(vpAdapter);
        // 设置监听
        viewPager.setOnPageChangeListener(this);

        // 初始化底部小点
        initPoint();
    }

    /**
     * 初始化底部小点
     */
    private void initPoint() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);

        points = new ImageView[views.size()];

        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            // 得到一个LinearLayout下面的每一个子元素
            points[i] = (ImageView) linearLayout.getChildAt(i);
            // 默认都设为灰色
            points[i].setEnabled(true);
            // 给每个小点设置监听
            points[i].setOnClickListener(this);
            // 设置位置tag，方便取出与当前位置对应
            points[i].setTag(i);
        }

        // 设置当面默认的位置
        currentIndex = 0;
        // 设置为白色，即选中状态
        points[currentIndex].setEnabled(false);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
        setCurDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    /**
     * 设置当前页面的位置
     */
    private void setCurView(int position) {
        if (position < 0 || position >= views.size()) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
    private void setCurDot(int positon) {
        if (positon < 0 || positon > views.size() - 1 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);

        currentIndex = positon;
    }

    public void startClick(View view) {
        setGuide();
        startActivity(new Intent(GuideActivity.this,MainActivity.class));
    }

    //设置下次不再引导
    private void setGuide() {
        sp = getSharedPreferences(SHAREDPREFERENCES_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(KEY_GUIDE_ACTIVITY,false);
        editor.apply();
    }


    private static class ViewPagerAdapter extends PagerAdapter{

        //界面列表
        private ArrayList<View> views;

        public ViewPagerAdapter(ArrayList<View> views)
        {
            this.views = views;
        }

        /**
         * 获得当前界面数
         */
        @Override
        public int getCount() {
            if (views != null) {
                return views.size();
            }
            else return 0;
        }


        /**
         * 销毁position位置的界面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        /**
         * 初始化position位置的界面
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        /**
         * 判断是否由对象生成界面
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
