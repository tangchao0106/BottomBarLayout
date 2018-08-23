package com.chaychan.bottombarlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;


public abstract class BaseFragment extends Fragment {

    private boolean isVisible;
    private boolean isViewCreated;
    protected String title;
    protected ImmersionBar mImmersionBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        Log.e("blink", "onCreateView");




        isViewCreated = true;
        title = getTitleView();
        initView(view);
        setView();

        if (isImmersionBarEnabled()){
            initImmersionBar();

        }
        return view;
    }


    /**
     * 是否在Fragment使用沉浸式
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).init();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
//            onInvisible();
        }
        if (isViewCreated && isVisible) {
        }

    }

    public abstract int getLayoutID();

    public abstract String getTitleView();

    public abstract void onVisible();//页面显示，更新数据

    public abstract void initView(View view);//页面初始化

    public abstract void setView();//页面显示并且view初始化完成：更新UI


}