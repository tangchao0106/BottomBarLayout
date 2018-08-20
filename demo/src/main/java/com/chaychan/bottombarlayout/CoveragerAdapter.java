package com.chaychan.bottombarlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CoveragerAdapter extends BaseAdapter {

    private Context context = null;

    private List<WorkBean> newDatas = new ArrayList<>();

    public CoveragerAdapter(Context context, List<WorkBean> workBeanList) {
        this.context = context;
        this.newDatas = workBeanList;
    }

    public void onDataCharges(Context context, List<WorkBean> workBeanList) {
        this.context = context;
        this.newDatas = workBeanList;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return newDatas == null ? 0 : newDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return newDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup viewGroup) {
        CpverageViewHolder cpverageViewHolder = null;
        if (contentView == null) {
            contentView = LayoutInflater.from(context).inflate(R.layout.item_gridview_coverager, viewGroup, false);
            cpverageViewHolder = new CpverageViewHolder(contentView);
            contentView.setTag(cpverageViewHolder);
        } else {
            cpverageViewHolder = (CpverageViewHolder) contentView.getTag();
        }
        final WorkBean workBean = (WorkBean) getItem(position);
        cpverageViewHolder.coverager_vager.setText(workBean.getTaskName());
        cpverageViewHolder.coverager_image.setImageResource(workBean.getSrcImage());
        cpverageViewHolder.item_gridview_layout.setBackgroundResource(R.drawable.labe_selector);
        cpverageViewHolder.item_gridview_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCallBack.positive(workBean.getTaskName());
            }
        });

        return contentView;
    }

    public interface ICallBack {
        void positive(String taskName);
    }

    ICallBack iCallBack;

    public void setIICallBack(ICallBack iCallBack) {
        this.iCallBack = iCallBack;
    }


    class CpverageViewHolder {

        ImageView coverager_image = null;

        TextView coverager_vager = null;

        LinearLayout item_gridview_layout = null;

        public CpverageViewHolder(View view) {
            coverager_image = (ImageView) view.findViewById(R.id.id_itemcoverager_number);
            coverager_vager = (TextView) view.findViewById(R.id.id_coverager_vager);
            item_gridview_layout = (LinearLayout) view.findViewById(R.id.item_gridview_layout);
        }
    }
}
