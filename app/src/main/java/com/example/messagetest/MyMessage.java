package com.example.messagetest;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MyMessage implements MultiItemEntity {
    public static final int ICI = 1;
    public static final int COMMENT = 2;
    public static final int LIKE = 3;

    String message="这是一条消息";
    String sender = "ici";
    int imageId=R.drawable.list_image;

    private int itemType=1;

    @Override
    public int getItemType() {
        return itemType;
    }

    public MyMessage(int itemType) {
        this.itemType=itemType;
    }

    public MyMessage() {
    }

    public MyMessage(String message, String sender, int imageId) {
        this.message = message;
        this.sender = sender;
        this.imageId = imageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
