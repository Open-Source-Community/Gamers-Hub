package com.an.gamers.Model_Classes;

public class Post {
    private String mId;
    private String Userid;
    private String mContent;
    private String mDate;
    private String mGroupid;

    public Post() {
    }

    public Post(String mId, String lUserid, String mContent, String mDate, String mGroupid) {
        this.mId = mId;
        this.Userid = lUserid;
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

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String lUsersid) {
        this.Userid = lUsersid;
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
