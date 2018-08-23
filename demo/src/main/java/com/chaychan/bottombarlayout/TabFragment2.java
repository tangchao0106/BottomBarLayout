package com.chaychan.bottombarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author ChayChan
 * @date 2017/6/23  11:22
 */
public class TabFragment2 extends BaseFragment {

    Toolbar toolbar;

    @Override
    public int getLayoutID() {
        return R.layout.tab_test_fragment_layout;
    }

    @Override
    public String getTitleView() {
        return null;
    }

    @Override
    public void onVisible() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .titleBar(toolbar)
                .init();
        //或者
        //ImmersionBar.setTitleBar(getActivity(),toolbar);
    }

    @Override
    public void initView(View view) {

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    }

    @Override
    public void setView() {

    }
}
