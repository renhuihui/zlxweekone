package com.example.zhaolingxiao20190218.data.contract;

import com.example.zhaolingxiao20190218.data.bean.HomeBean;

public interface IHomeContract {
    public interface IHomeView{
        public void showData(HomeBean homeBean);
    }
    public interface IHomePresenter<IHomeView>{
        public void bind(IHomeContract.IHomeView homeView);
        public void unbind(IHomeContract.IHomeView homeView);
        public void requestData();
    }
    public interface IHomeModel{
        public void containData(CallBack callBack);
        public interface CallBack{
            public void onCallBack(HomeBean data);
        }
    }
}
