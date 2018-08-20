package com.chaychan.bottombarlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;


import java.util.ArrayList;
import java.util.List;


public class MainFragment extends BaseFragment implements View.OnClickListener, CoveragerAdapter.ICallBack, ViewPager.OnPageChangeListener {

    MyViewPager myViewPager;
    View leftView;
    View rightView;

    //view集合
    private List<View> views;
    ImageView indexImageView;
    ArcView arcViewLeft;
    ArcView arcViewRight;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_mainview;
    }

    @Override
    public String getTitleView() {
        return null;
    }

    @Override
    public void onVisible() {

    }


    @Override
    public void initView(View view) {
        myViewPager = (MyViewPager) view.findViewById(R.id.home_viewpage);
        indexImageView = (ImageView) view.findViewById(R.id.viewpage_index_select);
        myViewPager.addOnPageChangeListener(this);
        //初始化数据统计viewpage
        LayoutInflater inflater = LayoutInflater.from(getContext());
        leftView = inflater.inflate(R.layout.viewpage_home_statistics_one, null);
        rightView = inflater.inflate(R.layout.viewpage_home_statistics_one, null);

        arcViewLeft = (ArcView) leftView.findViewById(R.id.arc_left);
        arcViewRight = (ArcView) leftView.findViewById(R.id.arc_right);
        testArcView();

        views = new ArrayList<>();
        views.add(leftView);
        views.add(rightView);
        myViewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
    }

    //数据统计适配器
    PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            View view = views.get(position);
            //  缺陷和隐患数据显示


            return views.get(position);
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //viewpage选择监听
        switch (position) {

            case 0:
                indexImageView.setImageResource(R.mipmap.ic_viewpage_select_one);
                break;
            case 1:
                indexImageView.setImageResource(R.mipmap.ic_viewpage_select_two);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void setView() {
    }

    @Override
    public void onClick(View v) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mainview, null);
        initView(view);
        initValues();
        return view;
    }

    public void initValues() {


    }

    private void testArcView() {
        List<Times> times = new ArrayList<>();
        for (int i = 6; i > 0; i--) {
            Times t = new Times();
            t.hour = i;
            t.text = "Number" + i;
            times.add(t);
        }

        ArcView.ArcViewAdapter myAdapter = arcViewLeft.new ArcViewAdapter<Times>() {
            @Override
            public double getValue(Times times) {
                return times.hour;
            }

            @Override
            public String getText(Times times) {
                return times.text;
            }
        };//设置adapter
        myAdapter.setData(times);//设置数据集
        arcViewLeft.setMaxNum(1);//设置可以显示的最大数值 该数值之后的会合并为其他
//          arcView.setRadius(150);//设置圆盘半径

        ArcView.ArcViewAdapter myAdapterRight = arcViewRight.new ArcViewAdapter<Times>() {
            @Override
            public double getValue(Times times) {
                return times.hour;
            }

            @Override
            public String getText(Times times) {
                return times.text;
            }
        };//设置adapter
        myAdapterRight.setData(times);//设置数据集
        arcViewRight.setMaxNum(2);//设置可以显示的最大数值 该数值之后的会合并为其他
//          arcView.setRadius(150);//设置圆盘半径
    }

    class Times {
        double hour;
        String text;
    }

    @Override
    public void positive(String taskName) {
        switch (taskName) {
            case "设备巡视":

                break;
            case "缺陷管理":

                break;
            case "日常运维":


                break;
            case "运维制度":


                break;
            case "带电检测":


                break;
            case "倒闸操作":


                break;
            case "运维分析":

                break;
            case "台账管理":

                break;
            default:
        }

    }
}
