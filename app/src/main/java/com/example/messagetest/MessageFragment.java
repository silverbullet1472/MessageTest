package com.example.messagetest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;


import java.util.ArrayList;
import java.util.List;

import me.codego.view.DotLayout;

public class MessageFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyMessageAdapter mAdapter;
    private List<MyMessage> messages;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message,container,false);
        initView(view);
        return view;
    }


    private void initView (View view){
        messages = new ArrayList<MyMessage>();
        messages.add(new MyMessage(2));
        messages.add(new MyMessage(3));
        for (int i = 0; i < 4; i++) {
            messages.add(new MyMessage(1));
        }
        mSwipeRefreshLayout =(SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyMessageAdapter(messages);
        mAdapter.openLoadAnimation(1);
        mAdapter.isFirstOnly(false);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                MyMessage message = messages.get(position);
                switch (message.getItemType()){
                    case 1:
                        DotLayout dotLayout1 = (DotLayout)mAdapter.getViewByPosition(mRecyclerView,position,R.id.dot_layout);
                        dotLayout1.show(true,0);
                        Toast.makeText(getActivity(),"ici官方消息",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        DotLayout dotLayout2 = (DotLayout)mAdapter.getViewByPosition(mRecyclerView,position,R.id.dot_layout);
                        dotLayout2.show(true,105);
                        Toast.makeText(getActivity(),"评论信息"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        DotLayout dotLayout3 = (DotLayout)mAdapter.getViewByPosition(mRecyclerView,position,R.id.dot_layout);
                        dotLayout3.show(true,99);
                        Toast.makeText(getActivity(),"点赞信息",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        mRecyclerView.setAdapter(mAdapter);



        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        //给swipeRefreshLayout绑定刷新监听
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //设置2秒的时间来执行以下事件
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        messages.add(messages.size(),new MyMessage());
                        mAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });




    }



}
