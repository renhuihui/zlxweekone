package com.example.zhaolingxiao20190218.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhaolingxiao20190218.R;
import com.example.zhaolingxiao20190218.data.bean.HomeBean;
import com.example.zhaolingxiao20190218.data.contract.IHomeContract;
import com.example.zhaolingxiao20190218.presenter.HomePresenter;
import com.example.zhaolingxiao20190218.view.adapter.HomeAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    private HomePresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new HomePresenter();
        presenter.bind(this);
        presenter.requestData();
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void showData(HomeBean homeBean) {
        final List<HomeBean.DataBeanX.DataBean> data = homeBean.getData().getData();
        Toast.makeText(this, ""+data.toString(), Toast.LENGTH_SHORT).show();
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        final HomeAdapter homeAdapter = new HomeAdapter(R.layout.item, data);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                data.remove(position);
                homeAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind(this);
    }
}
