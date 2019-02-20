package com.an.gamers.Model_Classes;

import java.util.List;

public class Post {
    private String mId;
    private List<String> lUsersid;
    private String mContent;
    private String mDate;
    private String mGroupid;

    public Post() {
    }

    public Post(String mId, List<String> lUsersid, String mContent, String mDate, String mGroupid) {
        this.mId = mId;
        this.lUsersid = lUsersid;
        this.mContent = mContent;
        this.mDate = mDate;
        this.mGroupid = mGroupid;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public List<String> getlUsersid() {
        return lUsersid;
    }

    public void setlUsersid(List<String> lUsersid) {
        this.lUsersid = lUsersid;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmGroupid() {
        return mGroupid;
    }

    public void setmGroupid(String mGroupid) {
        this.mGroupid = mGroupid;
    }
}
