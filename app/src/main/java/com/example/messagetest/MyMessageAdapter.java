package com.example.messagetest;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyMessageAdapter extends BaseMultiItemQuickAdapter<MyMessage, BaseViewHolder> {
    public MyMessageAdapter(List data) {
        super(data);
        addItemType(MyMessage.ICI, R.layout.item_simple);
        addItemType(MyMessage.COMMENT, R.layout.item_comment_btn);
        addItemType(MyMessage.LIKE, R.layout.item_like_btn);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMessage item) {
        switch (helper.getItemViewType()) {
            case MyMessage.ICI:
                helper.setText(R.id.tv_sender, item.getSender());
                helper.setText(R.id.tv_message, item.getMessage());
                helper.setImageResource(R.id.img_sender, item.getImageId());
                // 加载网络图片
                //Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
                break;
            case MyMessage.COMMENT:
                break;
            case MyMessage.LIKE:
                break;
        }
    }
}
