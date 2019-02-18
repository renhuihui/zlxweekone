package com.example.zhaolingxiao20190218.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhaolingxiao20190218.R;
import com.example.zhaolingxiao20190218.data.bean.HomeBean;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeBean.DataBeanX.DataBean,BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<HomeBean.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBeanX.DataBean item) {
        helper.setText(R.id.textView,item.getTitle());
        Glide.with(mContext).load("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg").into((ImageView) helper.getView(R.id.imageView));
    }
}
