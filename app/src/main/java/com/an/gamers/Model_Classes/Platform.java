package com.an.gamers.Model_Classes;

import java.util.List;

public class Platform {
    private String mID;
    private String mName;
    private String mPhoto;
    private int mRate;
    private String mGroupId;
    private List<String> lIdgames;
    private int mUsersNum;
    private static int mCurrentUsers;

    public Platform() {
    }

    public Platform(String mID, String mName, String mPhoto, String groupId, List<String> lIdgames) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoto = mPhoto;
        this.mGroupId = groupId;
        this.lIdgames = lIdgames;
        mUsersNum=0;
        mCurrentUsers=0;
    }
    public void udatecureentusers()
    {
        mCurrentUsers=mCurrentUsers+1;
        ratecalc();
    }

    public void setmUsersNum(int mUsersNum) {
        this.mUsersNum = mUsersNum;


    }
    private void ratecalc()
    {
        float div=(mCurrentUsers/mUsersNum);
        mRate=(int)div*100;
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

    public String getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getmGroupId() {
        return mGroupId;
    }

    public void setmGroupId(String mGroupId) {
        this.mGroupId = mGroupId;
    }

    public List<String> getlIdgames() {
        return lIdgames;
    }

    public void setlIdgames(List<String> lIdgames) {
        this.lIdgames = lIdgames;
    }
}
