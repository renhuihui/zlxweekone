package com.example.zhaolingxiao20190218.presenter;

import com.example.zhaolingxiao20190218.data.bean.HomeBean;
import com.example.zhaolingxiao20190218.data.contract.IHomeContract;
import com.example.zhaolingxiao20190218.model.HttpUtils;

import java.lang.ref.SoftReference;

public class HomePresenter implements IHomeContract.IHomePresenter<IHomeContract.IHomeView> {
    IHomeContract.IHomeView homeView;
    private SoftReference<IHomeContract.IHomeView> reference;
    private HttpUtils model;

    @Override
    public void bind(IHomeContract.IHomeView homeView) {
        this.homeView = homeView;
        reference = new SoftReference<>(homeView);
        model = new HttpUtils();
    }

    @Override
    public void unbind(IHomeContract.IHomeView homeView) {
        reference.clear();
    }

    @Override
    public void requestData() {
        model.containData(new IHomeContract.IHomeModel.CallBack() {
            @Override
            public void onCallBack(HomeBean data) {
                homeView.showData(data);
            }
        });
    }
}
