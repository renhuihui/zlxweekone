package com.example.zhaolingxiao20190218.model;

import com.example.zhaolingxiao20190218.data.bean.HomeBean;
import com.example.zhaolingxiao20190218.data.constant.Constant;
import com.example.zhaolingxiao20190218.data.contract.IHomeContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class HttpUtils implements IHomeContract.IHomeModel {
    //单例模式
    static HttpUtils instance=null;
    private void Singleton(){}
    public static HttpUtils getInstance(){

        if(instance==null){

            instance=new HttpUtils();

        }
        return instance;
    }
    @Override
    public void containData(final CallBack callBack) {
        //get请求
        OkGo.<String>get(Constant.HOMEURL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String string = response.body().toString();
                Gson gson =  new Gson();
                HomeBean homeBean = gson.fromJson(string, HomeBean.class);
                callBack.onCallBack(homeBean);
            }
        });
    }
}
