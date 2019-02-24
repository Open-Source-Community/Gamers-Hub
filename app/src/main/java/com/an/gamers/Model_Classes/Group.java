package com.an.gamers.Model_Classes;

import java.util.List;

public class Group {
    private String mID;
    private String mName;
    private List<String> lPostsid;
    private List<String> lUsersid;

    public Group() {
    }

    public Group(String mID, String mName, List<String> lPostsid, List<String> lUsersid) {
        this.mID = mID;
        this.mName = mName;
        this.lPostsid = lPostsid;
        this.lUsersid = lUsersid;
    }

    public Group( String mName) {
        this.mName=mName;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public List<String> getlPostsid() {
        return lPostsid;
    }

    public void setlPostsid(List<String> lPostsid) {
        this.lPostsid = lPostsid;
    }

    public List<String> getlUsersid() {
        return lUsersid;
    }

    public void setlUsersid(List<String> lUsersid) {
        this.lUsersid = lUsersid;
    }
}
