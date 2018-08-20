package com.chaychan.bottombarlayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * @Project:energyfuture_app_client
 * @Package com.sh.abclient.adapter
 * @create_time:2017/5/9 11:13
 * @Description:  图片轮播adapter
 * @author:lxr
 * @version: v1.0.0
 */
public class MyPagerAdapter extends LoopPagerAdapter {

    private int[] image = null;

    public MyPagerAdapter(RollPagerView viewPager, int[] images) {
        super(viewPager);
        this.image = images;
    }

    /**
     * SetScaleType(ImageView.ScaleType.CENTER_CROP);
     * 按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽)
     */

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(image[position]);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }

    @Override
    public int getRealCount() {
        return image.length;
    }

}
